package com.daniel.budgetplanner.dashboard.domain.model

import com.daniel.budgetplanner.dashboard.data.local.entities.MovementEntity
import com.daniel.budgetplanner.dashboard.presentation.home.model.MovementItem

typealias DomainMovements = List<Movement>

typealias MovementsDb = List<MovementEntity>

typealias PresentationMovements = List<MovementItem>
