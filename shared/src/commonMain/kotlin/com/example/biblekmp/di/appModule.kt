package com.example.biblekmp.di


import androidx.lifecycle.SavedStateHandle
import com.example.biblekmp.services.BibleApi
import com.example.biblekmp.viewmodel.BibleViewModel
import com.example.biblekmp.viewmodel.ChapterViewModel
import com.example.biblekmp.viewmodel.GetChapterViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import org.koin.plugin.module.dsl.create



val appModule = module {
    single { create(::buildClient) }
    single <BibleApi>()
    viewModel<BibleViewModel>()

    viewModel{ChapterViewModel(bibleApi = get(), savedStateHandle = get())}
    viewModel <GetChapterViewModel>()


}


@OptIn(ExperimentalSerializationApi::class)
private fun buildClient(): HttpClient {
    return HttpClient(CIO) {
        engine {
            maxConnectionsCount = 1000
            endpoint {
                maxConnectionsPerRoute = 100
                pipelineMaxSize = 20
                keepAliveTime = 5000
                connectTimeout = 5000
                connectAttempts = 5
                pipelining = false
            }

        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                //useAlternativeNames = false
            })
            //gzip{}
            //zstd()
            /*Json{
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }

             */

        }

        defaultRequest {
            header("api-key", "fNrA7PAFdU-JvpekfF-oL")
            //header("ContentType", "text/plain")
            //header("Accept" ,"text/plain")

        }
    }
}

