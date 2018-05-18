package ca.etsmtl.etsmobile.data.repository.signets

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import ca.etsmtl.etsmobile.AppExecutors
import ca.etsmtl.etsmobile.data.api.ApiResponse
import ca.etsmtl.etsmobile.data.api.SignetsApi
import ca.etsmtl.etsmobile.data.db.dao.EtudiantDao
import ca.etsmtl.etsmobile.data.model.Resource
import ca.etsmtl.etsmobile.data.model.signets.Etudiant
import ca.etsmtl.etsmobile.data.model.signets.SignetsModel
import ca.etsmtl.etsmobile.data.model.signets.SignetsUserCredentials
import ca.etsmtl.etsmobile.data.repository.NetworkBoundResource
import javax.inject.Inject

/**
 * Created by Sonphil on 02-03-18.
 */

class InfoEtudiantRepository @Inject constructor(
    appExecutors: AppExecutors,
    private val api: SignetsApi,
    private val dao: EtudiantDao
) : SignetsRepository(appExecutors) {
    fun getInfoEtudiant(userCredentials: SignetsUserCredentials, shouldFetch: Boolean): LiveData<Resource<Etudiant>> {

        return object : NetworkBoundResource<Etudiant, SignetsModel<Etudiant>>(appExecutors) {
            override fun saveCallResult(item: SignetsModel<Etudiant>) {
                item.data?.let { dao.insert(it) }
            }

            override fun shouldFetch(data: Etudiant?): Boolean {
                return shouldFetch
            }

            override fun loadFromDb(): LiveData<Etudiant> {
                val resultLiveData = MediatorLiveData<Etudiant>()
                val dbLiveData = dao.getAll()
                resultLiveData.addSource(dbLiveData, {
                    if (it != null && it.isNotEmpty()) {
                        resultLiveData.value = it[0]
                    } else {
                        resultLiveData.value = null
                    }

                    resultLiveData.removeSource(dbLiveData)
                })

                return resultLiveData
            }

            override fun createCall(): LiveData<ApiResponse<SignetsModel<Etudiant>>> {
                return Transformations.switchMap(api.infoEtudiant(userCredentials)) { apiResponse ->
                    val resultLiveData = MutableLiveData<ApiResponse<SignetsModel<Etudiant>>>()
                    val errorStr = getError(apiResponse)

                    if (errorStr.isNullOrEmpty()) {
                        resultLiveData.value = apiResponse
                    } else {
                        resultLiveData.value = ApiResponse(Throwable(errorStr))
                    }

                    resultLiveData
                }
            }
        }.asLiveData()
    }
}
