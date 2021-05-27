/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.quiltmc.community

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.modules.extra.mappings.extMappings
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import org.quiltmc.community.extensions.SyncExtension
import org.quiltmc.community.extensions.messagelog.MessageLogExtension

@OptIn(PrivilegedIntent::class)
suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        intents {
            +Intents.all
        }

        members {
            all()
        }

        messageCommands {
            defaultPrefix = "?"

            check { it.message.author != null }
        }

        extensions {
            add(::MessageLogExtension)
            add(::SyncExtension)

            extMappings {}
        }
    }

    bot.start()
}
