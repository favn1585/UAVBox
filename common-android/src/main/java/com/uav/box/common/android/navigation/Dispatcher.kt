package com.uav.box.common.android.navigation

import android.content.Intent
import io.reactivex.MaybeEmitter
import io.reactivex.MaybeOnSubscribe
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Dispatcher @Inject constructor() {

    private val ongoingRequests: MutableMap<Int, RouterRequest> = ConcurrentHashMap(mutableMapOf())

    fun onResult(requestCode: Int, success: Boolean, data: Intent?) {
        ongoingRequests.forEach {
            val code = it.key
            val request = it.value
            if (requestCode == code) {
                request.onResult(code, success, data)
            }
        }
    }

    private inner class RouterRequest(private val requestCode: Int) : MaybeOnSubscribe<Result> {
        private lateinit var emitter: MaybeEmitter<Result>

        override fun subscribe(emitter: MaybeEmitter<Result>) {
            emitter.setCancellable {
                ongoingRequests.remove(requestCode)
            }
            this.emitter = emitter
        }

        fun onResult(requestCode: Int, success: Boolean, data: Intent?) {
            if (this.requestCode == requestCode) {
                val error = (data?.getSerializableExtra(EXTRA_RESULT_CANCELLED) as? Throwable)
                when {
                    success -> emitter.onSuccess(Result(requestCode, true, data))
                    error != null -> emitter.onError(error)
                    else -> emitter.onComplete()
                }
            }
        }
    }

    data class Result(val requestCode: Int, val success: Boolean, val data: Intent?)

    companion object {
        const val EXTRA_RESULT_CANCELLED = "extra_result_cancelled"
    }
}