package com.droidconke.chai.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

private fun <T> State<T>.toFlow() = snapshotFlow { this }

/**
 * Animates Chai's design properties, and returns a new instance
 * of Chai's design property in form of a [State]
 * @param initialValue initial value of the design resource/property must be of type ChaiDesign eg ChaiIcon
 * @param animationStates a list of animation states which are created from [animate*AsState] functions
 * @param targetBuilder a function that takes in a list of animated design properties and returns a single
 * value of type ChaiDesign (of type [T]) eg ChaiIcon wrapped in [State]
 * @return an animated state which is an instance ChaiDesign wrapped in [State]
 */
@Composable
internal inline fun <T> animateChaiAsState(
    initialValue: T,
    animationStates: List<State<*>>,
    crossinline targetBuilder: (animatedValues: List<Any>) -> T
): State<T> {
    val animationFlows: List<Flow<*>> = animationStates.map(State<*>::toFlow)
    // (combine scales linearly; find a better option probably)?
    return combine(flows = animationFlows) { _animationFlows ->
        targetBuilder(
            _animationFlows.mapIndexed { index, flow ->
                (flow as State<*>).value
                    ?: throw NullPointerException(
                        "animation of the individual element at index $index of type " +
                            "is null hence cannot be animated"
                    )
            }
        )
    }.collectAsState(initial = initialValue)
}