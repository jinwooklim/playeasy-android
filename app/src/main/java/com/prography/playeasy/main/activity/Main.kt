package com.prography.playeasy.main.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prography.playeasy.R
import com.prography.playeasy.lib.TokenManager
import com.prography.playeasy.match.domain.MatchDao
import com.prography.playeasy.match.domain.dtos.response.MatchListDto
import com.prography.playeasy.match.domain.models.Match
import com.prography.playeasy.util.UIHelper
import com.prography.playeasy.match.module.view.MatchRecyclerAdapter
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar

class Main : AppCompatActivity() {

    var matchList: List<Match>? = null
    var matchDao: MatchDao? = null

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_main_custom)
        matchList = ArrayList<Match>()
        Log.d("jwt token", TokenManager.get(applicationContext))
        matchDao = MatchDao(TokenManager.get(applicationContext))

        //step 1
        getCurrentDayMatch()

        try {
            matchList = createSampleMatch()
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        UIHelper.hideWindow(this)
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar))
        UIHelper.bottomNavigationInitialize(this, findViewById(R.id.bottomNavigation))

        val startDate: Calendar = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)
        val endDate: Calendar = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        var horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(this, R.id.calendarView).range(startDate, endDate)
                .datesNumberOnScreen(5).build()

        //step 2
        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar, position: Int) {
                val tempDateSend: String
                val day = date[Calendar.DAY_OF_MONTH]
                val month = date[Calendar.MONTH] + 1
                val year = date[Calendar.YEAR]
                Log.d(
                    "day, month, year",
                    day.toString() + month.toString() + year.toString()
                )
                tempDateSend = if (month <= 9) {
                    "$year-0$month-$day"
                } else {
                    "$year-$month-$day"
                }
                Log.d("temp", tempDateSend)
                val pattern = "yyyy-MM-dd"
                val simpleDateFormat =
                    SimpleDateFormat(pattern)
                try {
                    matchDao!!.retrieve(
                        simpleDateFormat.parse(tempDateSend),
                        object : Callback<MatchListDto> {
                            override fun onResponse(
                                call: Call<MatchListDto>,
                                response: Response<MatchListDto>
                            ) {
                                matchList = response.body()!!.matchList
                                Log.d("response", response.body().toString())
                                Log.d("list", matchList.toString())
                                Log.d(
                                    "response",
                                    response.body()!!.matchList.toString()
                                )
                                matchList = response.body()!!.matchList
                                adaptRecyclerView(matchList)
                            }

                            override fun onFailure(
                                call: Call<MatchListDto>,
                                t: Throwable
                            ) {
                                Log.d("통신 실패", "")
                            }
                        })
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
                //todo
            }
        }
    } // onCreate

    private fun adaptRecyclerView(matchList: List<Match>?) {
        val recyclerView = findViewById<RecyclerView>(R.id.MainRecycler)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = MatchRecyclerAdapter()
        recyclerView.adapter = adapter

        if (matchList == null) {
            Log.d("No match", "")
        } else {
            for (m in matchList) {
                adapter.addItems(m)
            }
        }
    }
}