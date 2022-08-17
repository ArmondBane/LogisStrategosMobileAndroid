package com.goodcomp.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.goodcomp.core.R
import com.goodcomp.core.data.local.dao.StratagemDao
import com.goodcomp.core.data.local.entity.StratagemEntity
import com.goodcomp.core.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [
        StratagemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun stratagemDao(): StratagemDao

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope,
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val stratagemDao = database.get().stratagemDao()

            applicationScope.launch {
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "DEATH TO THE FALSE EMPEROR!",
                        description = "The seething hatred that the Heretic Astartes harbour for the Corpse Emperor and his weakling, thin-blooded Space Marines is a weapon unto itself.",
                        faction = "Chaos Space Marines",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in the Fight phase, when a TRAITORIS ASTARTES unit from your army is selected to fight. Until the end of the phase, each time a HERETIC ASTARTES model in that unit makes a melee attack against an ADEPTUS ASTARTES or SANCTIC ASTARTES unit, you can re-roll the hit roll.",
                        pictureUri = R.drawable.death_to_the_false_emperor
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "DAEMONFORGE",
                        description = "The Daemon Engines of the Chaos Space Marines are driven by a fathomless hatred born of the warp.",
                        faction = "Chaos Space Marines",
                        style = "Battle Tactic Stratagem",
                        cost = "2CP/1CP",
                        effect = "Use this Stratagem in your Shooting phase or the Fight phase, when a TRAITORIS ASTARTES DAEMON ENGINE unit from your army is selected to shoot or fight. Until the end of the phase, improve the Weapon Skill and Ballistic Skill characteristics of models in that unit by 1. If that unit has the TITANIC keyword, this Stratagem costs 2CP; otherwise, it costs 1CP.",
                        pictureUri = R.drawable.daemonforge
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "FURY OF KHORNE",
                        description = "The bloodlust of Khorne’s followers is never sated, and is only heightened by the arterial sprays of their enemies’ gore.",
                        faction = "Chaos Space Marines (Khorne)",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in the Fight phase, when a TRAITORIS ASTARTES KHORNE unit from your army is selected to fight. Until the end of the phase, each time a model in that unit makes a melee attack, an unmodified hit roll of 6 automatically wounds the target.",
                        pictureUri = R.drawable.fury_of_khorne
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "GRANDFATHER’S BLESSINGS",
                        description = "Grandfather Nurgle bestows daemonic fecundity upon his faithful servants, sealing their gaping wounds with pulsating growths and replacing their spilt blood with curdling ichor.",
                        faction = "Chaos Space Marines (Nurgle)",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP/2CP",
                        effect = "Use this Stratagem in any phase, when a TRAITORIS ASTARTES NURGLE unit from your army is selected as the target of an attack. Until the end of the phase, each time an attack is made against that unit, an unmodified wound roll of 1-3 for that attack fails, irrespective of any abilities that the weapon or the model making the attack may have. If that unit contains 5 or fewer models, this Stratagem costs 1CP; otherwise, it costs 2CP.",
                        pictureUri = R.drawable.grandfathers_blessings
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "HATRED ETERNAL",
                        description = "Every Legionary harbours a reservoir of bitter hatred and resentment that they can draw upon to destroy their foes utterly.",
                        faction = "Chaos Space Marines",
                        style = "Battle Tactic Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem at the end of your Shooting phase or at the end of the Fight phase. Select one LEGIONARIES unit from your army; if it is the Shooting phase, that unit can shoot again; if it is the Fight phase and that unit is within Engagement Range of any enemy units, that LEGIONARIES unit can fight again.",
                        pictureUri = R.drawable.hatred_eternal
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "MURDEROUS PERFECTION",
                        description = "The desire for perfection that drives Slaanesh’s warriors is such that their fighting skills far exceed those of more blinkered forces - an obsessive drive that leads to superior acts of martial precision.",
                        faction = "Chaos Space Marines (Slaanesh)",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Shooting phase or the Fight phase, when a TRAITORIS ASTARTES SLAANESH unit from your army is selected to shoot or fight. Once during that phase, when resolving an attack made by a model in that unit, you can change the result of one hit roll, one wound roll or one damage roll to be a 6 (note that if a D3 is being rolled as part of that damage roll, that 6 is halved to a 3).",
                        pictureUri = R.drawable.murderous_perfection
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "VETERANS OF THE LONG WAR",
                        description = "Veterans of centuries or millennia, the Long War’s most embittered warriors have learnt how best to focus their need for vengeance.",
                        faction = "Chaos Space Marines",
                        style = "Battle Tactic Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem in your Shooting phase or the Fight phase, when a TRAITORIS ASTARTES INFANTRY or TRAITORIS ASTARTES BIKER unit from your army is selected to shoot or fight. Until the end of the phase, each time a model in that unit makes an attack, add 1 to that attack’s wound roll.",
                        pictureUri = R.drawable.veterans_of_the_long_war
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "WRATH OF THE CHOSEN",
                        description = "The merciless cruelty of a warband’s greatest warriors is both a deadly threat to their foes and a warning to potential rivals.",
                        faction = "Chaos Space Marines",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Shooting phase or the Fight phase, when a TRAITORIS ASTARTES TERMINATOR or CHOSEN unit from your army is selected to shoot or fight. Until the end of the phase, each time a model in that unit makes an attack, add 1 to that attack’s hit roll.",
                        pictureUri = R.drawable.wrath_of_the_chosen
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "BLASPHEMOUS MACHINES",
                        description = "The spirits of the most ancient or corrupted Chaos Space Marine war engines can be goaded to fury like wild beasts.",
                        faction = "Chaos Space Marines",
                        style = "Epic Deed Stratagem",
                        cost = "2CP/1CP",
                        effect = "Use this Stratagem in your Command phase. Select one TRAITORIS ASTARTES MACHINE SPIRIT or TRAITORIS ASTARTES DAEMON ENGINE model from your army that has a Wounds characteristic of 10 or more. Until the start of your next Command phase, that model is considered to have its full wounds remaining for the purposes of determining what characteristics on its profile to use. If that model has the TITANIC keyword, this Stratagem costs 2CP; otherwise, it costs 1CP.",
                        pictureUri = R.drawable.blasphemous_machines
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "FELL PRAYERS",
                        description = "Beseeching the Chaos Gods with fanatical fervour, the profane priests of the Heretic Astartes pray for diabolic boons, promising the vilest of offerings in return for their power.",
                        faction = "Chaos Space Marines",
                        style = "Epic Deed Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem at the start of any of your phases other than your Command phase. Select one TRAITORIS ASTARTES PRIEST model from your army that has not chanted a prayer this turn. That model can chant one prayer that has not already been chanted by a friendly model this turn. That prayer is automatically heard (do not roll) and takes effect until the start of your next Command phase.",
                        pictureUri = R.drawable.fell_prayers
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "FIRE FRENZY",
                        description = "The unbridled wrath of an enraged Helbrute is a useful tool in the hands of a commander who can direct it.",
                        faction = "Chaos Space Marines",
                        style = "Epic Deed Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your opponent’s Shooting phase, after an enemy unit has finished making its attacks. Select one TRAITORIS ASTARTES HELBRUTE model from your army that was hit by one or more of that enemy units attacks this phase, and which is not within Engagement Range of any enemy units. That HELBRUTE model can shoot as if it were your Shooting phase, but when doing so, it can only target either the closest enemy unit or an enemy unit containing any models that targeted that HELBRUTE model (and only if that enemy unit is an eligible target).",
                        pictureUri = R.drawable.fire_frenzy
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "THE GREAT SORCERER",
                        description = "Those not driven mad by the worship of Tzeentch are gifted with empyric powers to use against the Great Mutators enemies.",
                        faction = "Chaos Space Marines (Tzeentch)",
                        style = "Epic Deed Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem at the start of your Psychic phase. Select one TRAITORIS ASTARTES TZEENTCH PSYKER unit from your army, then select one of the following rules to apply to that unit:\n" +
                                "That unit can attempt to manifest one additional psychic power this phase.\n" +
                                "That unit can attempt to perform one psychic action and attempt to manifest one psychic power this phase.",
                        pictureUri = R.drawable.the_great_sorcerer
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "CONTEMPT OVER CAUTION",
                        description = "Allies are of little concern when a hated foe must be obliterated.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP/2CP",
                        effect = "Use this Stratagem in your Shooting phase. Select one <LEGION> CORE unit from your army that is not within Engagement Range of any enemy units, then select one enemy unit. Until the end of the phase:\n" +
                                "Models in that <LEGION> unit can target that enemy unit even if that enemy unit is within Engagement Range of other friendly units, provided those other friendly units are all <LEGION> units.\n" +
                                "Each time a model in that <LEGION> unit makes an attack against that enemy unit, you cannot re-roll the hit roll, and on an unmodified hit roll of 1, that attack scores a hit against one friendly <LEGION> unit of your choice within Engagement Range of that enemy unit instead (resolve any attacks against friendly units after resolving any attacks that hit that enemy unit).\n" +
                                "If all of the <LEGION> units within Engagement Range of the enemy unit you selected were CULTISTS units, this Stratagem costs 1CP; otherwise, it costs 2CP.",
                        pictureUri = R.drawable.contempt_over_caution
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "UNENDING DESTRUCTION",
                        description = "Chaos Space Marines are not easily diverted from their obsessive need to kill, and can accomplish their battlefield goals without having to relent in their acts of destruction.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem in your Shooting phase. Select one TRAITORIS ASTARTES INFANTRY unit from your army (excluding CULTISTS units) that is performing an action. That unit can shoot this phase without that action failing.",
                        pictureUri = R.drawable.unending_destruction
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "RELENTLESS DEVASTATION",
                        description = "The wrath of Chaos Space Marines is inescapable.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Movement phase, when a TRAITORIS ASTARTES INFANTRY unit (excluding CULTISTS units) from your army makes a Normal Move or Advances. Until the end of your Shooting phase, provided that unit does not move again, it is considered to have Remained Stationary.",
                        pictureUri = R.drawable.relentless_devastation
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "RITUAL OFFERINGS",
                        description = "Those unfortunate enough to be taken alive by Chaos Cultists only serve as fuel for their fanatical devotions.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem when an enemy unit is destroyed by a TRAITORIS ASTARTES CULTISTS unit from your army. Until the end of the battle:\n" +
                                "That CULTISTS unit automatically passes Morale tests.\n" +
                                "Each time a model in that CULTISTS unit makes a melee attack, add 1 to that attack’s hit roll.",
                        pictureUri = R.drawable.ritual_offerings
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "SCORN OF SORCERY",
                        description = "Like the deity they worship, the warriors of the Blood God despise psykers, and their sheer hatred can quell the sorceries of foes.",
                        faction = "Chaos Space Marines (Khorne)",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your opponent’s Psychic phase, after a Psychic test is passed for an enemy PSYKER unit and after any Deny the Witch test is taken. If that enemy PSYKER unit is within 24\" of any TRAITORIS ASTARTES KHORNE units from your army, roll one D6: on a 4+, that psychic power is denied.",
                        pictureUri = R.drawable.scorn_of_sorcery
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "SHROUD OF FLIES",
                        description = "With an incessant drone, a feculent swarm of immaterial flies enshrouds Nurgle’s devotees, obscuring their repulsive forms.",
                        faction = "Chaos Space Marines (Nurgle)",
                        style = "Strategic Ploy Stratagem",
                        cost = "3CP/2CP",
                        effect = "Use this Stratagem at the start of your opponent’s Shooting phase. Select one TRAITORIS ASTARTES NURGLE unit from your army. Until the end of the phase, each time an enemy model shoots, if that NURGLE unit is not the closest eligible target or within 12\" of that model, then until that shooting is resolved, that model cannot target that NURGLE unit. If that NURGLE unit has the MONSTER, VEHICLE, TERMINATOR or BIKER keyword, this Stratagem costs 3CP; otherwise, it costs 2CP.",
                        pictureUri = R.drawable.shroud_of_flies
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "TERRIFYING PHENOMENA",
                        description = "In the presence of Chaos Space Marines, gheist-like spirits moan and blood seeps from metal and rock, preying on the foes’ worst fears and driving them insane with terror.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem at the start of the Morale phase. Select one enemy unit within 12\" of a TRAITORIS ASTARTES CHAOS UNDIVIDED unit from your army. Until the end of the phase:\n" +
                                "Your opponent cannot select that unit for the Insane Bravery Stratagem, and cannot use any rule that would allow them to re-roll a Morale test for that unit.\n" +
                                "If that unit fails a Morale test, any action it is performing immediately fails.",
                        pictureUri = R.drawable.terrifying_phenomena
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "TIDE OF TRAITORS",
                        description = "The galaxy is filled with countless pathetic wretches hiding in the shadows and waiting for their opportunity to give themselves willingly to Chaos for the chance to win power and glory.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Command phase. Select one CULTISTS MOB unit from your army that is either within 6\" of a battlefield edge or within 6\" of your deployment zone. Up to D3+3 destroyed models can be added back to that unit. These returned models cannot be set up within Engagement Range of any enemy units, unless those enemy units are already within Engagement Range of that CULTISTS MOB unit.",
                        pictureUri = R.drawable.tide_of_traitors
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "EXCESSIVE CRUELTY",
                        description = "Slaanesh’s chosen delight in inflicting torment and cruelty, and they persecute terrified foes with renewed vigour.",
                        faction = "Chaos Space Marines (Slaanesh)",
                        style = "Strategic Ploy Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem when an enemy unit within Engagement Range of a TRAITORIS ASTARTES SLAANESH unit from your army Falls Back. After that enemy unit has finished that move, select one TRAITORIS ASTARTES SLAANESH unit from your army that that enemy unit was within Engagement Range of when this Stratagem was used. That SLAANESH unit can either consolidate up to 3\", or, if it is no longer within Engagement Range of any enemy units, shoot as if it were your Shooting phase. If the selected SLAANESH unit shoots, it can only target the enemy unit that Fell Back (and only if it is an eligible target).",
                        pictureUri = R.drawable.excessive_cruelty
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "VICIOUS DESCENT",
                        description = "Skyborne traitors strike without warning or mercy, catching the enemy unawares and eviscerating their formations before they can coordinate a counter-attack.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Charge phase, when a TRAITORIS ASTARTES JUMP PACK unit from your army finishes a charge move. Select one enemy unit within Engagement Range of that JUMP PACK unit, then roll one D6 for each model in that JUMP PACK unit that is within Engagement Range of that enemy unit. For each result that equals or exceeds that enemy unit’s Toughness characteristic, that enemy unit suffers 1 mortal wound.",
                        pictureUri = R.drawable.vicious_descent
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "WARP-BORN FORESIGHT",
                        description = "Those in thrall to Tzeentch are gifted with a measure of foresight, allowing them to scry the enemy’s myriad futures and pinpoint exactly where they will strike.",
                        faction = "Chaos Space Marines (Tzeentch)",
                        style = "Strategic Ploy Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem at the end of the Reinforcements step of your opponent’s Movement phase. Select one TRAITORIS ASTARTES TZEENTCH unit from your army that is not within Engagement Range of any enemy units, then select one enemy unit that is within 12\" of that unit and was set up as Reinforcements this turn. That TZEENTCH unit can shoot as if it were your Shooting phase, but if it does so, models in that unit can only target that enemy unit (and only if that enemy unit is an eligible target).",
                        pictureUri = R.drawable.warp_born_foresight
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "WINDS OF THE WARP",
                        description = "Some Heretic Astartes move almost faster than the eye can follow, leaving flickering trails of warpfiame in their wake.",
                        faction = "Chaos Space Marines",
                        style = "Strategic Ploy Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your opponent’s Shooting phase, when a TRAITORIS ASTARTES BIKER or TRAITORIS ASTARTES JUMP PACK unit from your army that Advanced in your previous Movement phase, or that was set up on the battlefield during the Reinforcements step of your previous Movement phase, is selected as the target of a ranged attack. Until the end of the phase, each time an attack is made against that unit, subtract 1 from that attack’s hit roll.",
                        pictureUri = R.drawable.winds_of_the_warp
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "DAEMON SHELLS",
                        description = "Crafted on tainted forge worlds and infused with warp energy, these shells release a mind-sickening scream as they are launched, voicing a craving to consume the soul of their target.",
                        faction = "Chaos Space Marines",
                        style = "Wargear Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Shooting phase, when a TRAITORIS ASTARTES unit from your army is selected to shoot. Until the end of the phase:\n" +
                                "Add 6\" to the Range characteristic of all bolt weapons models in that unit are equipped with.\n" +
                                "Each time a model in that unit makes a ranged attack with a bolt weapon, improve the Armour Penetration characteristic of that attack by 1.",
                        pictureUri = R.drawable.daemon_shells
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "INFERNAL ENGINE",
                        description = "The furnace at the heart of the Daemon Engine burns to incandescent levels as it channels the energies of the warp into its metal frame, daemon flesh and cursed iron flowing like filthy wax as ragged wounds reknit.",
                        faction = "Chaos Space Marines",
                        style = "Wargear Stratagem",
                        cost = "2CP/1CP",
                        effect = "Use this Stratagem in your opponent’s Shooting phase or the Fight phase, when a TRAITORIS ASTARTES DAEMON ENGINE model from your army is selected as the target of an attack. Until the end of the phase, each time an attack is allocated to that model, subtract 1 from the Damage characteristic of that attack (to a minimum of 1). If that model has the TITANIC keyword, this Stratagem costs 2CP; otherwise, it costs 1CP.",
                        pictureUri = R.drawable.infernal_engine
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "SKYSHRIKE MISSILE",
                        description = "Skyshrike missiles are designed to eliminate the foe’s aerial assets by unleashing a sigil-scrawled payload that shreds armour and ruptures vital systems.",
                        faction = "Chaos Space Marines",
                        style = "Wargear Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Shooting phase, when a TRAITORIS ASTARTES INFANTRY model from your army targets an AIRCRAFT unit with a missile launcher. That model can only make one attack with that weapon this phase, but when resolving that attack, add 1 to that attack’s hit roll. If a hit is scored, the target suffers 2D3 mortal wounds and the attack sequence ends.",
                        pictureUri = R.drawable.skyshrike_missile
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "SMOKESCREEN",
                        description = "Whether unleashing warp-fume canisters from hull-mounted launchers, sickly smoke from blood-burning embrasures or some other malign artifice, Chaos Space Marines' thrice-cursed vehicles can screen their acts of vengeance from the enemy.",
                        faction = "Chaos Space Marines",
                        style = "Wargear Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your opponent’s Shooting phase, when a TRAITORIS ASTARTES SMOKESCREEN unit from your army is selected as the target of an attack. Until the end of the phase, each time an attack is made against that unit, subtract 1 from that attack’s hit roll.",
                        pictureUri = R.drawable.smokescreen
                    )
                )

                //Word Bearer's stratagems:

                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "CURSED DESPOILERS",
                        description = "The sites the enemy deem valuable must be cast down and despoiled in the name of the Dark Gods. Only the foolish would stand between the Word Bearers and their unholy task.",
                        faction = "Word Bearers",
                        style = "Battle Tactic Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem in your Shooting phase, when a WORD BEARERS CORE or WORD BEARERS DAEMONKIN unit from your army that is engaged in Wanton Massacre is selected to shoot. Select one enemy unit within 12\" of that unit and in range of an objective marker. Each time a HERETIC ASTARTES model in that WORD BEARERS unit makes an attack with a Rapid Fire, Assault or Pistol weapon against that enemy unit, an unmodified hit roll of 4-5 scores 1 additional hit. Note that, combined with the Wanton Massacre bonus itself, this means that an unmodified hit roll of 4+ scores 1 additional hit.",
                        pictureUri = R.drawable.cursed_despoilers
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "FANATIC ZEALOTRY",
                        description = "Fervent mortal followers flock to the champions of the Word Bearers, damning their souls seeking promises of dark power.",
                        faction = "Word Bearers",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in your Command phase. Select one WORD BEARERS CULTISTS unit from your army within 12\" of a friendly WORD BEARERS CHARACTER unit. Until the start of your next Command phase:\n" +
                                "You can re-roll charge rolls made for that unit.\n" +
                                "Each time a model in that unit makes a melee attack, you can re-roll that attack’s hit roll.",
                        pictureUri = R.drawable.fanatic_zealotry
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "REVERED HOSTS",
                        description = "There is no greater way to venerate Chaos than to bond mortal with daemon. When battle is joined, the daemons within such warriors can burn through their soul, boosting their unholy power.",
                        faction = "Word Bearers",
                        style = "Battle Tactic Stratagem",
                        cost = "2CP",
                        effect = "Use this Stratagem in the Fight phase, when a WORD BEARERS DAEMON unit from your army is selected to fight. Until the end of the phase, each time a model in that unit makes a melee attack, you can re-roll the wound roll.",
                        pictureUri = R.drawable.revered_hosts
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "VENGEANCE FOR MONARCHIA",
                        description = "Never will the outrage in beloved Monarchia be forgiven; the idols toppled there by Guillimans sons will be reforged from their bones.",
                        faction = "Word Bearers",
                        style = "Battle Tactic Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in the Fight phase, when a WORD BEARERS unit from your army is selected to fight. Until the end of the phase, each time a HERETIC ASTARTES model in that unit makes a melee attack against an ULTRAMARINES unit, or against a unit that is a successor Chapter of the Ultramarines, you can re-roll the hit roll and you can re-roll wound roll.",
                        pictureUri = R.drawable.vengeance_for_monarchia
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "CURSED DESPOILERS",
                        description = "With gruesome offerings and ritualised promises, the Word Bearers seek the protection of their infernal masters.",
                        faction = "Word Bearers",
                        style = "Epic Deed Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in any phase, when a WORD BEARERS INFANTRY CHARACTER model from your army is destroyed. Instead of using any other rules that are triggered when that model is destroyed, you can choose for that model to make a dark pact. If you do so, mark that model’s position then remove that model from the battlefield. At the end of the phase, roll one D6: on a 4+, set that model back up on the battlefield as close as possible to the position you marked and not within Engagement Range of any enemy units, with D3 wounds remaining. Each model can only be selected for this Stratagem once per battle.",
                        pictureUri = R.drawable.dark_pact
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "MALEVOLENT COVENANT",
                        description = "When the warp provides, a price must always be paid...",
                        faction = "Word Bearers",
                        style = "Epic Deed Stratagem",
                        cost = "1CP/2CP",
                        effect = "Use this Stratagem in your Psychic phase, when a WORD BEARERS PSYKER unit from your army fails a Psychic test. You can choose for that PSYKER unit to suffer 1 mortal wound; if you do so, this Stratagem costs 1CP (otherwise, it costs 2CP). In either case, that psychic test is considered to have been passed at the minimum required warp charge value, without a double having been rolled, and cannot be denied by any Deny the Witch tests.",
                        pictureUri = R.drawable.malevolent_covenant
                    )
                )
                stratagemDao.insertStratagems(
                    StratagemEntity(
                        name = "HEXAGRAMMATIC WARD",
                        description = "Diabolical wards of protection can turn aside the enemy’s blows.",
                        faction = "Word Bearers",
                        style = "Wargear Stratagem",
                        cost = "1CP",
                        effect = "Use this Stratagem in any phase, when an attack is allocated to a WORD BEARERS model from your army. The Damage characteristic of that attack is changed to 0. You can only use this Stratagem once, unless you are playing a Strike Force or Onslaught battle (in which cases, you can use this Stratagem twice).",
                        pictureUri = R.drawable.hexagrammatic_ward
                    )
                )
            }
        }
    }

    companion object {
        const val DATABASE_NAME = "logis_strategos_database.db"
    }
}