package com.example.g2_cotizaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.g2_cotizaciones.barramenu1.BarraMenu1
import com.example.g2_cotizaciones.cotizacionesaprobadas7.CotizacionesAprobadas7
//import com.example.g2_cotizaciones.cotizacionespendientes3.BarraFiltroyBuscar2Instance
import com.example.g2_cotizaciones.cotizacionespendientes3.CotizacionesPendientes3
import com.example.g2_cotizaciones.notificacioncotizacion5.NotificacionCotizacion5
import com.example.g2_cotizaciones.ui.theme.G2_CotizacionesTheme
import com.example.g2_cotizaciones.viscoticompletada8.VisCotiCompletada8
import com.example.g2_cotizaciones.visualizacioncoti4.VisualizacionCoti4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // Crear el controlador de navegación

            // Configurar la navegación con Navigation Component
            NavHost(
                navController = navController,
                startDestination = "pantalla1"
            ) {
                composable("pantalla1") {
                    // Pantalla 1
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        CotizacionesPendientes3(
                            tapMenu = {
                                // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                                navController.navigate("pantalla2")
                            },
                            tapPendientes = {
                                // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                                navController.navigate("pantalla1")
                            },
                            tapAprobadas = {
                                // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                                navController.navigate("pantalla3")
                            },
                            tapCotizar = {
                                navController.navigate("pantalla4")
                            }
                        )
                    }
                }
                composable("pantalla2") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    BarraMenu1()
                }
                composable("pantalla3") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    CotizacionesAprobadas7(
                        clickPendientes = {
                            // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                            navController.navigate("pantalla1")
                        },
                        clickAprobadas = {
                            // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                            navController.navigate("pantalla3")
                        },
                        clickVer = {
                            navController.navigate("pantalla6")
                        },
                        clickMenu = {
                            navController.navigate("pantalla2")
                        }
                    )
                }
                composable("pantalla4") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    VisualizacionCoti4(
                        clickRegistrar = {
                            // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                            navController.navigate("pantalla5")
                        },
                        clickCancelar = {
                            // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                            navController.navigate("pantalla1")
                        }
                    )
                }
                composable("pantalla5") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    NotificacionCotizacion5(
                        clickAceptar = {
                            // Navegar a la siguiente pantalla al hacer clic en "Aceptar"
                            navController.navigate("pantalla3")
                        }
                    )
                }
                composable("pantalla6") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    VisCotiCompletada8(
                        clickRetroceder = {
                            navController.navigate("pantalla3")
                        }
                    )
                }
                composable("pantalla7") {
                    // Pantalla 2 (CotizacionesPendientes3)
                    //BarraFiltroyBuscar2Instance()
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    G2_CotizacionesTheme {
        CotizacionesPendientes3()
        //VisualizacionCoti4()
        //VisCotiCompletada8()
        //CotizacionesAprobadas7()
    }
}