package ca.etsmtl.repository.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ca.etsmtl.repository.data.db.dao.signets.ActiviteDao
import ca.etsmtl.repository.data.db.dao.signets.CoursDao
import ca.etsmtl.repository.data.db.dao.signets.EnseignantDao
import ca.etsmtl.repository.data.db.dao.signets.EtudiantDao
import ca.etsmtl.repository.data.db.dao.signets.EvaluationDao
import ca.etsmtl.repository.data.db.dao.signets.HoraireExamenFinalDao
import ca.etsmtl.repository.data.db.dao.signets.JourRemplaceDao
import ca.etsmtl.repository.data.db.dao.signets.ProgrammeDao
import ca.etsmtl.repository.data.db.dao.signets.SeanceDao
import ca.etsmtl.repository.data.db.dao.signets.SessionDao
import ca.etsmtl.repository.data.db.dao.signets.SommaireElementsEvaluationDao
import ca.etsmtl.repository.data.db.entity.signets.ActiviteEntity
import ca.etsmtl.repository.data.db.entity.signets.CoursEntity
import ca.etsmtl.repository.data.db.entity.signets.EnseignantEntity
import ca.etsmtl.repository.data.db.entity.signets.EtudiantEntity
import ca.etsmtl.repository.data.db.entity.signets.EvaluationEntity
import ca.etsmtl.repository.data.db.entity.signets.HoraireExamenFinalEntity
import ca.etsmtl.repository.data.db.entity.signets.JourRemplaceEntity
import ca.etsmtl.repository.data.db.entity.signets.ProgrammeEntity
import ca.etsmtl.repository.data.db.entity.signets.SeanceEntity
import ca.etsmtl.repository.data.db.entity.signets.SessionEntity
import ca.etsmtl.repository.data.db.entity.signets.SommaireElementsEvaluationEntity

/**
 * Created by Sonphil on 13-03-18.
 */
@Database(
        entities = [
            ProgrammeEntity::class,
            HoraireExamenFinalEntity::class,
            CoursEntity::class,
            ActiviteEntity::class,
            EnseignantEntity::class,
            EtudiantEntity::class,
            JourRemplaceEntity::class,
            EvaluationEntity::class,
            SessionEntity::class,
            SommaireElementsEvaluationEntity::class,
            SeanceEntity::class
        ],
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun programmeDao(): ProgrammeDao
    abstract fun horaireExamenFinalDao(): HoraireExamenFinalDao
    abstract fun coursDao(): CoursDao
    abstract fun activiteDao(): ActiviteDao
    abstract fun enseignantDao(): EnseignantDao
    abstract fun etudiantDao(): EtudiantDao
    abstract fun jourRemplaceDao(): JourRemplaceDao
    abstract fun evaluationDao(): EvaluationDao
    abstract fun sessionDao(): SessionDao
    abstract fun sommaireElementsEvaluationDao(): SommaireElementsEvaluationDao
    abstract fun seanceDao(): SeanceDao
}