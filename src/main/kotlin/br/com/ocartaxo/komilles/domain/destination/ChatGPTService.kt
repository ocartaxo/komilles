package br.com.ocartaxo.komilles.domain.destination

import com.aallam.openai.api.completion.CompletionRequest
import com.aallam.openai.api.completion.TextCompletion
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import kotlin.time.Duration.Companion.seconds

@Component
class ChatGPTService {

    private val logger = LoggerFactory.getLogger(ChatGPTService::class.java)

    @Value("\${openai.api_key}")
    private lateinit var TOKEN: String

    fun generateDescription(locationName: String, length: Int = 100): String {

        logger.info("Gerando descrição para `$locationName` usando o ChatGPT!")

        var completion: TextCompletion

        runBlocking {

            val prompt = "Faça um resumo sobre $locationName enfatizando o porque este lugar é incrível." +
                    "Utilize uma linguagem informal e até $length caracteres no máximo em cada parágrafo." +
                    "Crie 2 parágrafos neste resumo."


            val openai = OpenAI(
                token = TOKEN,
                timeout = Timeout(socket = 60.seconds),
            )

            val request = CompletionRequest(
                model = ModelId("gpt-3.5-turbo"),
                prompt = prompt,
                echo = true
            )
            completion = openai.completion(request)

        }

        return completion.choices[0].text
    }


}