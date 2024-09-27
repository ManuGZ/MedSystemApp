package com.manuel.medsystemapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuel.medsystemapp.common.Resource
import com.manuel.medsystemapp.common.UIState
import com.manuel.medsystemapp.data.repository.AppointmentRepository
import com.manuel.medsystemapp.domain.Appointment
import kotlinx.coroutines.launch

class AppointmentViewModel(private val repository: AppointmentRepository) : ViewModel() {

    private val _state = mutableStateOf(UIState<List<Appointment>>())
    val state: State<UIState<List<Appointment>>> get() = _state

    init {
        getAppointments()
    }

    private fun getAppointments() {
        _state.value = UIState(isLoading = true)

        viewModelScope.launch {
            val result = repository.getAppointments()
            if (result is Resource.Success) {
                _state.value = UIState(data = result.data)
            } else {
                _state.value = UIState(message = result.message ?: "An error occurred.")
            }
        }
    }
}