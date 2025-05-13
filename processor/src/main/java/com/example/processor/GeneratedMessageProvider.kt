package com.example.processor
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider


class GeneratedMessageProvider :SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return GeneratedMessageProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger
        )
    }
}
