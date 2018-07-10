package ca.etsmtl.repository.data.db.entity.signets

import android.arch.persistence.room.Entity

@Entity(primaryKeys = ["sigleCours", "session"])
data class SommaireElementsEvaluationEntity(
    var sigleCours: String,
    var session: String,
    var noteACeJour: String,
    var scoreFinalSur100: String,
    var moyenneClasse: String,
    var ecartTypeClasse: String,
    var medianeClasse: String,
    var rangCentileClasse: String,
    var noteACeJourElementsIndividuels: String,
    var noteSur100PourElementsIndividuels: String
)