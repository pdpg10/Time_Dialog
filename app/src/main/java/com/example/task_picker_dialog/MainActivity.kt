package com.example.task_picker_dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
    , DatePickerDialog.OnDateSetListener
    , TimePickerDialog.OnTimeSetListener {

    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    private val dateFormat = SimpleDateFormat("yyyy.MMM.dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_time.setOnClickListener {
            val calendar = Calendar.getInstance()
            val h = calendar.get(Calendar.HOUR_OF_DAY)
            val m = calendar[Calendar.MINUTE]
            val timePicker = TimePickerDialog(this, this, h, m, true)
            timePicker.show()
        }

        tv_date.setOnClickListener {
            val calendar = Calendar.getInstance()
            val y = calendar.get(Calendar.YEAR)
            val m = calendar[Calendar.MONTH]
            val d = calendar[Calendar.DAY_OF_MONTH]
            val datePicker = DatePickerDialog(this, this, y, m, d)
            datePicker.show()
        }

    }

    override fun onTimeSet(
        view: TimePicker?,
        hourOfDay: Int,
        minute: Int
    ) {
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = hourOfDay
        calendar[Calendar.MINUTE] = minute
        val strTime = timeFormat.format(calendar.time)
        tv_time.text = strTime
    }

    override fun onDateSet(
        view: DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        val calendar = Calendar.getInstance()
        calendar[Calendar.YEAR] = year
        calendar[Calendar.MONTH] = month
        calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
        val strTime = dateFormat.format(calendar.time)
        tv_date.text = strTime
    }
}
