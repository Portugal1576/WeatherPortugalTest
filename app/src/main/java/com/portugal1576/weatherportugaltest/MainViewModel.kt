package com.portugal1576.weatherportugaltest

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.portugal1576.weatherportugaltest.utils.API_KEY
import org.json.JSONObject
import java.lang.IllegalArgumentException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(application = application) as T
            }
            throw IllegalArgumentException("Unknow ViewModel Class")
        }
    }


    fun getData(name: String,
                context: Context,
                temp_c: MutableState<String>,
                temp_f: MutableState<String>) {
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&" +
                "q=$name" +
                "&aqi=no"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                temp_c.value = temp.getString("temp_c")
                temp_f.value = temp.getString("temp_f")
                Log.d("MyLog", "Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog", "Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }



    fun chosenCity( context: Context) {
        Log.d("MyLog", "name")
    }

}



