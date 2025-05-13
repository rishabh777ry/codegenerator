package com.example.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import java.io.OutputStreamWriter

/**
 * Symbol processor that generates a file with a message.
 */
class GeneratedMessageProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    private var invoked = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        // Only process once
        if (invoked) {
            return emptyList()
        }
        invoked = true

        // Generate the message file
        generateMessageFile()

        return emptyList()
    }

    private fun generateMessageFile() {
        try {
            val packageName = "com.example.generated"
            val fileName = "GeneratedMessage"
            val fileContent = """
                package $packageName
                
                
         object Name {
        var count : Int = 0
        val name : String = "hey from ksp Rishabh "
    }
 
               
   
                
            """.trimIndent()

            // Create a new file in the specified package with the given name
            val file = codeGenerator.createNewFile(
                dependencies = Dependencies(false), // No dependencies needed for unconditional generation
                packageName = packageName,
                fileName = fileName
            )

            // Write the content to the file
            OutputStreamWriter(file).use { writer ->
                writer.write(fileContent)
            }

            logger.info("Successfully generated $fileName.kt in $packageName")
        } catch (e: Exception) {
            logger.error("Error generating file: ${e.message}")
        }
    }
}