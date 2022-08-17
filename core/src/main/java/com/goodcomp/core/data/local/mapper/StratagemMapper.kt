package com.goodcomp.core.data.local.mapper

import com.goodcomp.core.data.local.entity.StratagemEntity
import com.goodcomp.core.domain.entity.Stratagem

fun StratagemEntity.toStratagem() =
    Stratagem(
        name = name,
        description = description,
        faction = faction,
        style = style,
        cost = cost,
        effect = effect,
        picture = pictureUri
    )