package com.msu.webapp.webapp.services

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class Init(): CommandLineRunner {

    private val onStartLogger = LoggerFactory.getLogger(Init::class.java)

    override fun run(vararg args: String?) {
        onStartLogger.info("Starting user configurating...");
        onStartLogger.info("Configuration finished");
    }
}