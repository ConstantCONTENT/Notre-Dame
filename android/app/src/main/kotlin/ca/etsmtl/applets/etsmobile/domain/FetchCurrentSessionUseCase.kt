package ca.etsmtl.applets.etsmobile.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ca.etsmtl.applets.etsmobile.R
import ca.etsmtl.applets.etsmobile.presentation.App
import model.Resource
import ca.etsmtl.applets.repository.data.repository.signets.SessionRepository
import ca.etsmtl.applets.repository.util.timeInSeconds
import model.Session
import model.SignetsUserCredentials
import java.util.Date
import javax.inject.Inject

/**
 * Created by Sonphil on 13-10-18.
 */

class FetchCurrentSessionUseCase @Inject constructor(
    private val userCredentials: SignetsUserCredentials,
    private val sessionRepository: SessionRepository,
    private val app: App
) {
    operator fun invoke(): LiveData<Resource<Session>> {
        return Transformations.map(sessionRepository.getSessions(userCredentials) { true }) { res ->
            val sessions = res.data.orEmpty()
            val currentSession = sessions.find { session ->
                Date().timeInSeconds in session.dateDebut..session.dateFin
            } ?: sessions.getPreviousSession()
            ?: sessions.lastOrNull()

            if (res.status == Resource.Status.LOADING) {
                Resource.loading(currentSession)
            } else if (res.status == Resource.Status.ERROR || currentSession == null) {
                Resource.error(res.message ?: app.getString(R.string.error), currentSession)
            } else {
                Resource.success(currentSession)
            }
        }
    }

    private fun List<Session>.getPreviousSession(): Session? = findLast { session ->
        Date().timeInSeconds > session.dateFin
    }
}