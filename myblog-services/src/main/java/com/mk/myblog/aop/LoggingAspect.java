package com.mk.myblog.aop;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Pointcut that matches all repositories, services and REST endpoints.
	 */
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *) || within(@org.springframework.stereotype.Service *) || within(@org.springframework.stereotype.Repository *)")
	public void springBeanPointcut() {
		// Method is empty as this is just a Pointcut, implementations are in advices
	}

	/**
	 * Pointcut that matches all public methods
	 */
	@Pointcut("execution(public * com.mk.myblog..*(..))")
	public void allMethodsPointcut() {
	}

	// =================================================
	// Advice
	// 1. This is the actual action to be taken either before or after the method
	// execution.
	// 2. This is actual piece of code that is invoked during program execution by
	// Spring AOP framework.
	// =================================================
	/**
	 * Logging method for all controller classes.
	 * 
	 * @param joinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("springBeanPointcut() && allMethodsPointcut()")
	public Object doLoggingForControllers(ProceedingJoinPoint joinPoint) throws Throwable {
		return log(joinPoint, Level.INFO);
	}

	/**
	 * Used to log the messages
	 * 
	 * @param proceedingJoinPoint
	 * @param logLevel
	 * @return Object
	 * @throws Throwable
	 */
	private Object log(final ProceedingJoinPoint proceedingJoinPoint, Level logLevel) throws Throwable {
		final StopWatch stopWatch = new StopWatch();
		Object returnValue = null;
		stopWatch.start();
		final String aClassName = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
		final String aMethodName = proceedingJoinPoint.getSignature().getName();
		if (null != logLevel) {
			log.info("{}={}.{}()", "ENTERED_METHOD", aClassName, aMethodName);
			try {
				returnValue = proceedingJoinPoint.proceed();
			} catch (Exception exception) {
				stopWatch.stop();
				log.info("{}={}.{}() {}={}", "EXITED_METHOD", aClassName, aMethodName, "TIME", stopWatch.getTime());
				log.error(exception.getMessage());
				throw exception;
			}
			stopWatch.stop();
			log.info("{}={}.{}() {}={}", "EXITED_METHOD", aClassName, aMethodName, "RESPONSE_TIME",
					stopWatch.getTime());
		} else {
			returnValue = proceedingJoinPoint.proceed();
		}
		return returnValue;
	}
}
