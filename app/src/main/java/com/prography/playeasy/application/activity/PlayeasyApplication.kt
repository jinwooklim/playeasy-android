package com.prography.playeasy.application.activity

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class PlayeasyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "@string/kakao_app_key")
    }
}