package com.andrejzdravev.task.`interface`

import com.andrejzdravev.task.model.Factss

interface CommonResponseListener {
    fun onSuccessResponse(result: Factss?, code: Int)
    fun onError(msg: String)
}