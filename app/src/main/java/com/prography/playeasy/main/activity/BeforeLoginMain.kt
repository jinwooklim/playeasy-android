package com.prography.playeasy.main.activity

//import com.prography.playeasy.login.activity.LoginActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.prography.playeasy.R
import com.prography.playeasy.match.domain.models.Match
import com.prography.playeasy.util.UIHelper
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class BeforeLoginMain : AppCompatActivity() {
    val handler: Handler = Handler()
    val DELAY_MILLIS: Long = 2500

    val run: Runnable = Runnable() {
//         fun run() {
//            val intent: Intent = Intent(getApplicationContext(), LoginActivity::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//            finish()
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_beforelogin)

        UIHelper.hideWindow(this)
        UIHelper.toolBarInitialize(this, findViewById<View>(R.id.MainToolbar))

        val startDate: Calendar = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        val endDate: Calendar = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        var horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(this, R.id.calendarView).range(startDate, endDate)
                .datesNumberOnScreen(5).build()

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar?, position: Int) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(run, DELAY_MILLIS)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(run)
    }
}

fun getCurrentDayMatch() {
    val currentDate = Date()
    val pattern = "yyyy-MM-dd"
    val simpleDateFormat = SimpleDateFormat(pattern)
    val date = simpleDateFormat.format(currentDate)
    Log.d("현재 날짜 ", date)
}

@Throws(ParseException::class)
fun createSampleMatch(): List<Match>? {
    val matchArr: List<Match> =
        ArrayList()
    val sdf = SimpleDateFormat("yyyy-MM-dd")
//        matchArr.add(new Match(28,"SOCCER", "축구뜨자", sdf.parse("2020-07-11"), 180, 3000, "010-9165-6918", 11));
//        matchArr.add(new Match(1,"FOOTSAL5", "풋살 즐기", sdf.parse("2020-07-12"), 180, 5000, "010-916/5-6918", 5));
    return matchArr
}