package sk.foo.nestedscopetest

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FooViewModel {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun init() {
        Log.d("Default", "a")
        scope.launch {
            Log.d("Default", "b")
            flowOf("hello")
                .collect {
                    Log.d("Default", "c")
                }
        }
        Log.d("Default", "d")
    }
}