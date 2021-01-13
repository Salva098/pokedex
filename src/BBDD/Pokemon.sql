-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bvrp7p5nq78vomv3rqqa-mysql.services.clever-cloud.com:3306
-- Generation Time: Jan 12, 2021 at 01:30 PM
-- Server version: 8.0.13-3
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bvrp7p5nq78vomv3rqqa`
--
CREATE DATABASE IF NOT EXISTS `Pokemon` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Pokemon`;
-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `usuario` varchar(255) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`usuario`, `contrasena`) VALUES
('123', '123'),
('admin', 'admin'),
('Lorenzo', '123'),
('Salva', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `pokemon`
--

CREATE TABLE `pokemon` (
  `n_pokemon` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Altura` float DEFAULT NULL,
  `Categoria` varchar(255) DEFAULT NULL,
  `Peso` float DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Habilidad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pokemon`
--

INSERT INTO `pokemon` (`n_pokemon`, `Nombre`, `Altura`, `Categoria`, `Peso`, `Descripcion`, `Habilidad`) VALUES
(1, 'Bulbasaur', 0.7, 'Semilla', 6.9, 'Este Pokemon nace con una semilla en el lomo, que brota con el paso del tiempo.', 'Espesura'),
(2, 'Ivysaur', 1, 'Semilla', 13, 'Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.', 'Espesura'),
(3, 'Venusaur', 2, 'Semilla', 100, 'La planta florece cuando absorbe energia solar, lo cual le obliga a buscar siempre la luz del sol.', 'Espesura'),
(4, 'Charmander', 0.6, 'Lagartija', 8.5, 'Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.', 'Mar Llamas'),
(5, 'Charmeleon', 1.1, 'Llama', 19, 'Este Pokemon de naturaleza agresiva ataca en combate con su cola llameante y hace trizas al rival con sus afiladas garras.', 'Mar Llamas'),
(6, 'Charizard', 1.7, 'Llama', 90.5, 'Escupe un fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.', 'Mar Llamas'),
(7, 'Squirtle', 0.5, 'Tortuguita', 9, 'Cuando retrae su largo cuello en el caparazon, dispara agua a una presion increible.', 'Torrente'),
(8, 'Wartortle', 1, 'Tortuga', 22.5, 'Se lo considera un simbolo de longevidad. Los ejemplares mas ancianos tienen musgo sobre el caparazon.', 'Torrente'),
(9, 'Blastoise', 1.6, 'Armazon', 85.5, 'Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. En momentos de apuro, se esconde en el caparazón.', 'Torrente'),
(10, 'Caterpie', 0.3, 'Gusano', 2.9, 'Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos.', 'Polvo Escudo'),
(11, 'Metapod', 0.7, 'Capullo', 9.9, 'Como en este estado solo puede endurecer su coraza, permanece inmovil a la espera de evolucionar.', 'Mudar'),
(12, 'Butterfree', 1.1, 'Mariposa', 32, 'Aletea a gran velocidad para lanzar al aire sus escamas extremadamente toxicas.', 'Ojo Compuesto'),
(13, 'Weedle', 0.3, 'Oruga', 3.2, 'El aguijon de la cabeza es muy puntiagudo. Se alimenta de hojas oculto en la espesura de bosques y praderas.', 'Polvo Escudo'),
(14, 'Kakuna', 0.6, 'Capullo', 10, 'Aunque es casi incapaz de moverse, en caso de sentirse amenazado puede envenenar a los enemigos con su aguijon.', 'Mudar'),
(15, 'Beedrill', 1, 'Abeja Veneno', 29.5, 'Tiene tres aguijones venenosos, dos en las patas anteriores y uno en la parte baja del abdomen, con los que ataca a sus enemigos una y otra vez.', 'Enjambre'),
(16, 'Pidgey', 0.3, 'Pajarito', 1.8, 'Su docilidad es tal que suelen defenderse levantando arena en lugar de contraatacar.', 'Vista Lince'),
(17, 'Pidgeotto', 1.1, 'Pajarito', 30, 'Su extraordinaria vitalidad y resistencia le permiten cubrir grandes distancias del territorio que habita en busca de presas.', 'Vista Lince'),
(18, 'Pidgeot', 1.5, 'Pajarito', 39.5, 'Este Pokemon vuela a una velocidad de 2 mach en busca de presas. Sus grandes garras son armas muy peligrosas.', 'Vista Lince'),
(19, 'Rattata', 0.3, 'Raton', 3.5, 'Es propenso a hincar los incisivos en cualquier cosa que se le ponga por delante. Si se ve alguno, seguramente haya cuarenta cerca.', 'Fuga'),
(20, 'Raticate', 0.7, 'Raton', 18.5, 'Gracias a las pequenas membranas de las patas traseras, puede nadar por los rios para capturar presas.', 'Fuga'),
(21, 'Spearow', 0.3, 'Pajarito', 2, 'A la hora de proteger su territorio, compensa su incapacidad para volar a gran altura con una increible velocidad.', 'Vista Lince'),
(22, 'Fearow', 1.2, 'Pico', 38, 'Este Pokemon ha existido desde tiempos remotos. Al menor atisbo de peligro, alza el vuelo y huye.', 'Vista Lince'),
(23, 'Ekans', 2, 'Serpiente', 6.9, 'La longitud de este Pokemon aumenta con el tiempo. Por la noche, se enrosca en las ramas de los arboles para descansar.', 'Mudar'),
(24, 'Arbok', 3.5, 'Cobra', 65, 'Se han llegado a identificar hasta seis variaciones distintas de los espeluznantes dibujos de su piel.', 'Mudar'),
(25, 'Pikachu', 0.4, 'Raton', 6, 'Cuanto mas potente es la energia electrica que genera este Pokemon, mas suaves y elasticas se vuelven las bolsas de sus mejillas.', 'Electricidad'),
(26, 'Raichu', 0.8, 'Raton', 30, 'Su larga cola le sirve como toma de tierra para protegerse a si mismo del alto voltaje que genera su cuerpo.', 'Electricidad'),
(27, 'Sandshrew', 0.6, 'Raton', 12, 'Le gusta revolcarse por la arena seca para eliminar todo rastro de suciedad y humedad en la piel.', 'Velo Arena'),
(28, 'Sandslash', 1, 'Raton', 29.5, 'Cuanto mas seco es el terreno en el que habita, mas duras y lisas se vuelven las puas que le recubren la espalda.', 'Velo Arena'),
(29, 'Nidoranf', 0.4, 'Pin Veneno', 7, 'Posee un olfato mas fino que los Nidoran(H). Usa los bigotes para percibir la direccion del viento y buscar comida a sotavento de sus depredadores.', 'Punto Tóxico'),
(30, 'Nidorina', 0.8, 'Pin Veneno', 20, 'Se cree que el cuerno de la frente se le ha atrofiado para evitar herir a sus crias al alimentarlas.', 'Punto Tóxico'),
(31, 'Nidoqueen', 1.3, 'Taladro', 60, 'Su defensa destaca sobre la capacidad ofensiva. Usa las escamas del cuerpo como una coraza para proteger a su prole de cualquier ataque.', 'Punto Tóxico'),
(32, 'Nidoranm', 0.5, 'Pin Veneno', 9, 'Mantiene sus grandes orejas levantadas, siempre alerta. Si advierte peligro, ataca inoculando una potente toxina con su cuerno frontal.', 'Punto Tóxico'),
(33, 'Nidorino', 0.9, 'Pin Veneno', 19.5, 'Dondequiera que va, parte rocas con su cuerno, mas duro que un diamante, en busca de una Piedra Lunar.', 'Punto Tóxico'),
(34, 'Nidoking', 1.4, 'Taladro', 62, 'Una vez que se desboca, no hay quien lo pare. Solo se calma ante Nidoqueen, su companera de toda la vida.', 'Punto Tóxico'),
(35, 'Clefairy', 0.6, 'Hada', 7.5, 'Se dice que la felicidad llegara a quien vea un grupo de Clefairy bailando a la luz de la luna llena.', 'Gran Encanto'),
(36, 'Clefable', 1.3, 'Hada', 40, 'Este Pokemon de aspecto feerico, raramente visto por los humanos, corre a esconderse en cuanto detecta que hay alguien cerca.', 'Gran Encanto'),
(37, 'Vulpix', 0.6, 'Zorro', 9.9, 'De pequeño, tiene seis colas de gran belleza. A medida que crece, le van saliendo más.', 'Absorbe Fuego'),
(38, 'Ninetales', 1.1, 'Zorro', 19.9, 'Cuentan que llega a vivir hasta mil años y que cada una de las colas posee poderes sobrenaturales.', 'Absorbe Fuego'),
(39, 'Jigglypuff', 0.5, 'Globo', 5.5, 'Su capacidad pulmonar es excepcional, incluso para un Pokemon. Es capaz de cantar nanas sin cesar hasta que su rival se duerma.', 'Gran Encanto'),
(40, 'Wigglytuff', 1, 'Globo', 12, 'Cuanto más aire inhala, más aumenta de tamaño. Si se enfada, hincha el cuerpo con el fin de intimidar a su oponente.', 'Gran Encanto'),
(41, 'Zubat', 0.8, 'Murcielago', 7.5, 'Emite ondas ultrasonicas por la boca para escrutar el entorno, lo que le permite volar con pericia por cuevas angostas.', 'Foco Interno'),
(42, 'Golbat', 1.6, 'Murcielago', 55, 'Le encanta chuparles la sangre a los seres vivos. En ocasiones comparte la preciada colecta con otros congeneres hambrientos.', 'Foco Interno'),
(43, 'Oddish', 0.5, 'Hierbajo', 5.4, 'Se mueve al exponerse a la luz de la luna. Merodea por la noche para esparcir sus semillas.', 'Clorofila'),
(44, 'Gloom', 0.8, 'Hierbajo', 8.6, 'Libera un fétido olor por los pistilos. El fuerte hedor hace perder el conocimiento a cualquiera que se encuentre en un radio de 2 km.', 'Clorofila'),
(45, 'Vileplume', 1.2, 'Flor', 18.6, 'Tiene los petalos mas grandes del mundo. Al caminar, de ellos se desprenden densas nubes de polen toxico.', 'Clorofila'),
(46, 'Paras', 0.3, 'Hongo', 5.4, 'Escarba en el suelo para extraer nutrientes de las raices de los arboles, que las setas del lomo absorben despues casi por completo.', 'Efenco Espora'),
(47, 'Parasect', 1, 'Hongo', 29.5, 'Tras largo tiempo absorbiendo la energia del huesped, la seta parasita del lomo es la que parece controlar la voluntad de este Pokemon.', 'Efenco Espora'),
(48, 'Venonat', 1, 'Insecto', 30, 'Sus grandes ojos actuan como radares. A plena luz se percibe que son, en realidad, grupos de ojos diminutos.', 'Ojo Compuesto'),
(49, 'Venomoth', 1.5, 'Polilla Venenosa', 12.5, 'Las alas desprenden un polvillo de escamas impregnado de toxinas que se adhiere al contacto y resulta dificil de quitar.', 'Polvo Escudo'),
(50, 'Diglett', 0.2, 'Topo', 0.8, 'Si un Diglett excava un terreno, lo deja perfectamente arado y preparado para sembrarlo.', 'Velo Arena'),
(51, 'Dugtrio', 0.7, 'Topo', 33.3, 'Un trio de Diglett. Causa enormes terremotos al cavar en el subsuelo a profundidades de hasta 100 km.', 'Velo Arena'),
(52, 'Meowth', 0.4, 'Gato Arana', 4.2, 'Le encanta reunir objetos brillantes. Cuando esta de buen humor, hasta le muestra la coleccion a su Entrenador.', 'Recogida'),
(53, 'Persian', 1, 'Gato Arana', 32, 'Trabar amistad con este Pokémon es una ardua tarea debido a su enorme orgullo. Cuando algo no le place, saca las uñas de inmediato.', 'Experto'),
(54, 'Psyduck', 0.8, 'Pato', 19.6, 'Siempre padece dolores de cabeza. Tras desatar sus misteriosos poderes, la jaqueca remite unos instantes.', 'Humedad'),
(55, 'Golduck', 1.7, 'Pato', 76.6, 'Habita en rios de aguas placidas. Sus largas extremidades le permiten nadar con gracilidad.', 'Humedad'),
(56, 'Mankey', 0.5, 'Mono Cerdo', 28, 'Este agil Pokemon vive en los arboles. Se enfada con facilidad y, cuando lo hace, se abalanza contra todo lo que se encuentre a su alrededor.', 'Espiritu Vital'),
(57, 'Primeape', 1, 'Mono Cerdo', 32, 'Solo se calma cuando no hay nadie cerca, por lo que llegar a ver ese momento resulta verdaderamente dificil.', 'Espiritu Vital'),
(58, 'Growlithe', 0.7, 'Perrito', 19, 'De naturaleza valiente y honrada, se enfrenta sin miedo a enemigos mas grandes y fuertes.', 'Intimidacion'),
(59, 'Arcanine', 1.9, 'Leyenda', 155, 'Es capaz de correr 10 000 km al dia, lo que deja embelesados a todos los que lo ven pasar.', 'Intimidacion'),
(60, 'Poliwag', 0.6, 'Renacuajo', 12.5, 'Es mas agil en el agua que en la tierra. La espiral de su vientre no es mas que parte de sus visceras que se ven a traves de la piel.', 'Humedad'),
(61, 'Poliwhirl', 1, 'Renacuajo', 20, 'Mirar fijamente la espiral de su vientre provoca somnolencia, por lo que puede usarse como alternativa a las nanas para dormir a los ninos.', 'Humedad'),
(62, 'Poliwrath', 1.3, 'Renacuajo', 54, 'Su cuerpo es puro musculo. Logra abrirse paso por aguas gelidas partiendo el hielo con sus fornidos brazos.', 'Humedad'),
(63, 'Abra', 0.9, 'Psi', 19.5, 'Es capaz de usar sus poderes psiquicos aun estando dormido. Al parecer, el contenido del sueno influye en sus facultades.', 'Foco Interno'),
(64, 'Kadabra', 1.3, 'Psi', 56.5, 'Duerme suspendido en el aire gracias a sus poderes psiquicos. La cola, de una flexibilidad extraordinaria, hace las veces de almohada.', 'Foco Interno'),
(65, 'Alakazam', 1.5, 'Psi', 48, 'Posee una capacidad intelectual fuera de lo común que le permite recordar todo lo sucedido desde el instante de su nacimiento.', 'Foco Interno'),
(66, 'Machop', 0.8, 'Suoerpoder', 19.5, 'Es una masa de musculos y, pese a su pequeno tamano, tiene fuerza de sobra para levantar en brazos a 100 personas.', 'Agallas'),
(67, 'Machoke', 1.5, 'Suoerpoder', 70.5, 'Su musculoso cuerpo es tan fuerte que usa un cinto antifuerza para controlar sus movimientos.', 'Agallas'),
(68, 'Machamp', 1.6, 'Suoerpoder', 130, 'Mueve rapidamente sus cuatro brazos para asestar incesantes golpes y punetazos desde todos los angulos.', 'Agallas'),
(69, 'Bellsprout', 0.7, 'Flor', 4, 'Prefiere lugares calidos y humedos. Atrapa pequenos Pokemon insectos con sus lianas para devorarlos.', 'Clorofila'),
(70, 'Weepinbell', 1, 'Matamoscas', 6.4, 'Cuando tiene hambre, engulle a todo lo que se mueve. La pobre presa acaba disuelta en sus acidos.', 'Clorofila'),
(71, 'Victreebel', 1.7, 'Matamoscas', 15.5, 'Atrae a su presa con un dulce aroma a miel. Una vez atrapada en la boca, la disuelve en tan solo un dia, huesos incluidos.', 'Clorofila'),
(72, 'Tentacool', 0.9, 'Medusa', 45.5, 'Sus facultades natatorias son mas bien escasas, por lo que se limita a flotar a la deriva en aguas poco profundas en busca de alimento.', 'Cuerpo Puro'),
(73, 'Tentacruel', 1.6, 'Medusa', 55, 'Si las esferas rojas que tiene a ambos lados de la cabeza brillan con intensidad, indica que esta a punto de lanzar ondas ultrasonicas.', 'Cuerpo Puro'),
(74, 'Geodude', 0.4, 'Roca', 20, 'Se suele encontrar en senderos de montana y sitios parecidos. Conviene andar con cuidado para no pisarlo sin querer y provocar su enfado.', 'Cabeza Roca'),
(75, 'Graveler', 1, 'Roca', 105, 'Se le suele ver rodando montana abajo. No evita los obstaculos, sino que los arrolla.', 'Cabeza Roca'),
(76, 'Golem', 1.4, 'Megaton', 300, 'Nada mas mudar la piel, su cuerpo se vuelve blando y blanquecino, pero se endurece al poco tiempo de entrar en contacto con el aire.', 'Cabeza Roca'),
(77, 'Ponyta', 1, 'Caballo Fuego', 30, 'Al nacer es un poco lento, pero va fortaleciendo las patas paulatinamente al disputar carreras con sus congeneres.', 'Fuga'),
(78, 'Rapidash', 1.7, 'Caballo Fuego', 95, 'Su ardiente crin ondea al viento mientras atraviesa extensas praderas a una velocidad de 240 km/h.', 'Fuga'),
(79, 'Slowpoke', 1.2, 'Atontado', 36, 'Es lento y abstraido. Aunque le devoren la cola, ni siquiera se percata, ya que no siente ningun dolor. Tampoco nota cuando le vuelve a crecer.', 'Despiste'),
(80, 'Slowbro', 1.6, 'Ermitaño', 78.5, 'Ha evolucionado despues de que lo mordiera un Shellder, al cual le embelesa la sustancia que secreta por la cola.', 'Despiste'),
(81, 'Magnemite', 0.3, 'Iman', 6, 'A veces se desploman al suelo tras agotar su suministro electrico interno, pero basta una pequena bateria para reanimarlos.', 'Robustez'),
(82, 'Magneton', 1, 'Iman', 60, 'Este Pokemon, surgido de la union de tres Magnemite, genera potentes ondas de radio con las que examina el entorno.', 'Robustez'),
(83, 'Farfetchd', 0.8, 'Pato Salvaje', 15, 'Blande el puerro que sujeta con un ala como si se tratase de una espada para rebanar a su rival. En caso de necesidad, se lo come para nutrirse.', 'Vista Lince'),
(84, 'Doduo', 1.4, 'Ave Gemela', 39.2, 'Las diminutas alas apenas le permiten volar, pero puede correr a gran velocidad gracias a sus patas hiperdesarrolladas.', 'Fuga'),
(85, 'Dodrio', 1.8, 'Ave Triple', 85.2, 'Este Pokemon surge al dividirse una de las cabezas de Doduo. Es capaz de correr por las praderas a 60 km/h.', 'Fuga'),
(86, 'Seel', 1.1, 'Leon Marino', 90, 'Le encantan los lugares gelidos y disfruta nadando en aguas a temperaturas en torno a los -10 *C.', 'Sebo'),
(87, 'Dewgong', 1.7, 'Leon Marino', 120, 'Su cuerpo es blanco como la nieve. Puede nadar placidamente en mares gelidos gracias a su resistencia al frio.', 'Sebo'),
(88, 'Grimer', 0.9, 'Lodo', 30, 'Esta hecho de lodo endurecido. Pocos se atreven a tocarlo debido a su pestilencia y composicion nociva. Alla por donde pasa no crece la hierba.', 'Hedor'),
(89, 'Muk', 1.2, 'Lodo', 30, 'Huele tan mal que puede provocar desmayos. Su nariz se ha atrofiado de tal manera que ha perdido por completo el sentido del olfato.', 'Hedor'),
(90, 'Shellder', 0.3, 'Bivalvo', 4, 'Nada hacia atras abriendo y cerrando su concha. Es sorprendentemente rapido.', 'Caoarazon'),
(91, 'Cloyster', 1.5, 'Bivalvo', 132.5, 'La concha que lo cubre es extremadamente dura, hasta el punto de que ni siquiera una bomba puede destrozarla. Solo se abre cuando ataca.', 'Caoarazon'),
(92, 'Gastly', 1.3, 'Gas', 0.1, 'Nacio a partir de gases venenosos que asfixiarian a cualquiera que se viera envuelto en ellos.', 'Levitacion'),
(93, 'Haunter', 1.6, 'Gas', 0.1, 'Su lengua esta hecha de gas. Si lame a su victima, esta sufrira constantes temblores hasta fallecer.', 'Levitacion'),
(94, 'Gengar', 1.5, 'Sombra', 40.5, 'Las noches de luna llena, a este Pokemon le gusta imitar las sombras de la gente y burlarse de sus miedos.', 'Cuerpo Maldito'),
(95, 'Onix', 8.8, 'Serpiente Roca', 210, 'Al abrirse paso bajo tierra, va absorbiendo todo lo que encuentra. Eso hace que su cuerpo sea asi de solido.', 'Cabeza Roca'),
(96, 'Drowzee', 1, 'Hipnosis', 32.5, 'Si se duerme siempre en compania de un Pokemon de esta especie, puede mostrar suenos que haya ingerido con anterioridad.', 'Insomnio'),
(97, 'Hypno', 1.6, 'Hipnosis', 75.6, 'Conviene evitar el contacto visual en caso de encontrarse con este Pokemon, ya que puede hipnotizar con su pendulo.', 'Insomnio'),
(98, 'Krabby', 0.4, 'Cangrejo', 6.5, 'Es facil encontrarlo cerca del mar. Las largas pinzas que tiene vuelven a crecer si se las quitan de su sitio.', 'Caparazon'),
(99, 'Kingler', 1.3, 'Tenaza', 60, 'La pinza tan grande que tiene posee una fuerza de 10 000 CV, pero le cuesta moverla por su gran tamano.', 'Caparazon'),
(100, 'Voltorb', 0.5, 'Bola', 10.4, 'Se dice que se camufla como una Poke Ball. Al mas minimo estimulo se autodestruira.', 'Electricidad Estatica'),
(101, 'Electrode', 1.2, 'Bola', 66.6, 'Almacena tal cantidad de energia electrica en su cuerpo que el mas leve impacto puede provocar una gran explosion.', 'Electricidad Estatica'),
(102, 'Exeggcute', 0.4, 'Huevo', 2.5, 'Pese a su aspecto de mera pina de huevos, se trata de un Pokemon. Al parecer, sus cabezas se comunican entre si por telepatia.', 'Clorofila'),
(103, 'Exeggutor', 2, 'Coco', 120, 'Cada una de las tres cabezas piensa de forma independiente y apenas muestra interes por el resto.', 'Clorofila'),
(104, 'Cubone', 0.4, 'Solitario', 6.5, 'Cuando llora al acordarse de su madre fallecida, su llanto resuena en el craneo que lleva en la cabeza.', 'Cabeza Roca'),
(105, 'Marowak', 1, 'Apilahueso', 45, 'Ha evolucionado tras fortalecerse y superar su pena. Ahora lucha con arrojo blandiendo su hueso a modo de arma.', 'Cabeza Roca'),
(106, 'Hitmonlee', 1.5, 'Patada', 49.8, 'Este Pokemon tiene un sentido del equilibrio increible. Puede dar patadas desde cualquier posicion.', 'Flexibilidad'),
(107, 'Hitmonchan', 1.4, 'Puñetazo', 50.2, 'Sus punetazos cortan el aire. Son tan veloces que el minimo roce podria causar una quemadura.', 'Vista Lince'),
(108, 'Lickitung', 1.2, 'Lametazo', 65.5, 'Si sus lametones no se tratan a tiempo, su saliva pegajosa y urticante puede provocar picores persistentes.', 'Despiste'),
(109, 'Koffing', 0.6, 'Gas Venenoso', 1, 'Su cuerpo esta lleno a rebosar de gas venenoso. Acude a los vertederos atraido por el putrefacto olor que emana de los desperdicios.', 'Levitacion'),
(110, 'Weezing', 1.2, 'Gas Venenoso', 9.5, 'Usa sus dos cuerpos para mezclar gases. Segun parece, en el pasado podian hallarse ejemplares por todos los rincones de Galar.', 'Levitacion'),
(111, 'Rhyhorn', 1, 'Clavos', 115, 'Su inteligencia es limitada, aunque posee una fuerza tan considerable que le permite incluso derribar rascacielos con solo embestirlos.', 'Cabeza Roca'),
(112, 'Rhydon', 1.9, 'Taladro', 120, 'Cuando evoluciona, comienza a andar con las patas traseras. Es capaz de horadar rocas con el cuerno que tiene.', 'Cabeza Roca'),
(113, 'Chansey', 1.1, 'Huevo', 34.6, 'Los huevos que pone Chansey tienen un valor nutritivo altisimo y un sabor exquisito. Se consideran un manjar.', 'Cura Natural'),
(114, 'Tangela', 1, 'Enredadera', 35, 'Sus lianas no dejan de crecer aunque se le desprendan. Aun se desconoce que aspecto tiene sin ellas.', 'Clorofila'),
(115, 'Kangaskhan', 2.2, 'Maternal', 80, 'Aunque lleve una cria en el marsupio, su juego de pies no pierde ligereza. Abruma al rival con rafagas de agiles punetazos.', 'Madrugar'),
(116, 'Horsea', 0.4, 'Dragon', 8, 'Habita en mares de aguas tranquilas. Si se siente en peligro, expulsara por la boca una densa tinta negra para poder huir.', 'Nado Rapido'),
(117, 'Seadra', 1.2, 'Dragon', 25, 'En esta especie, es el macho quien se ocupa de la prole. Durante la epoca de cria, el veneno de las puas de su espalda se vuelve mas potente.\n\n', 'Punto Toxico'),
(118, 'Goldeen', 0.6, 'Pez Color', 15, 'Sus aletas pectorales, caudal y dorsal ondean graciles en el agua. Por eso se le llama el Bailarin Acuatico.', 'Nado Rapido'),
(119, 'Seaking', 1.3, 'Pez Color', 39, 'En otono gana algo de peso para atraer a posibles parejas y se cubre de llamativos colores.', 'Nado Rapido'),
(120, 'Staryu', 0.8, 'Estrella', 34.5, 'A finales de verano, se pueden ver grupos de Staryu en la orilla de la playa sincronizando el brillo de sus nucleos a ritmo regular.', 'Cura Nastural'),
(121, 'Starmie', 1.1, 'Misterioso', 80, 'Su organo central, conocido como nucleo, brilla con los colores del arcoiris cuando se dispone a liberar sus potentes poderes psiquicos.', 'Cura Natural'),
(122, 'mrmime', 1.3, 'Barrera', 54.5, 'Muchos estudiosos sostienen que el desarrollo de sus enormes manos se debe a su afan por practicar la pantomima.', 'Insonorizar'),
(123, 'Scyther', 1.5, 'Mantis', 56, 'Sus guadanas se vuelven mas afiladas con cada combate. Es capaz de rebanar troncos gruesos de un tajo.', 'Enjambre'),
(124, 'Jynx', 1.4, 'Forma Humana', 40.6, 'En cierta parte de Galar se conocia a Jynx como la Reina del Hielo y se reverenciaba con cierto temor.', 'Despiste'),
(125, 'Electabuzz', 1.1, 'Electrico', 30, 'Es habitual que las centrales electricas cuenten con Pokemon de tipo Tierra para hacer frente a los Electabuzz avidos de electricidad.', 'Electricidad'),
(126, 'Magmar', 1.3, 'Escupefuego', 44.5, 'Abate a sus presas con las llamas que genera y con frecuencia acaba reduciendolas a carbonilla por accidente.', 'Cuerpo Llama'),
(127, 'Pinsir', 1.5, 'Escarabajo', 55, 'Los Pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto mas imponente sea, mas agradara a sus congeneres del sexo opuesto.', 'Corte Fuerte'),
(128, 'Tauros', 1.4, 'Toro Bravo', 88.4, 'Conviene tener cuidado si empieza a fustigarse con las colas, pues es senal de que va a cargar a maxima velocidad.', 'Intimidacion'),
(129, 'Magikarp', 0.9, 'Pez', 10, 'Es el Pokemon mas debil y patetico que existe, con una fuerza y velocidad practicamente nulas.', 'Nado Rapido'),
(130, 'Gyarados', 6.5, 'Atrocidad', 235, 'Es exageradamente agresivo. El Hiperrayo que lanza por la boca reduce a cenizas todo lo que encuentra.\n\n', 'Intimidacion'),
(131, 'Lapras', 2.5, 'Transporte', 220, 'Este Pokemon posee una notable inteligencia y un corazon de oro. Entona un canto melodioso mientras surca el mar.', 'Absorbe Agua'),
(132, 'Ditto', 0.3, 'Transformacion', 4, 'Redistribuye las celulas de su cuerpo para cobrar la apariencia de lo que ve, pero vuelve a la normalidad al relajarse.', 'Flexivilidad'),
(133, 'Eevee', 0.3, 'Evolucion', 6.5, 'Es capaz de alterar la composicion de su cuerpo para adaptarse al entorno.', 'Fuga'),
(134, 'Vaporeon', 1, 'Burbuja', 29, 'Cuando las aletas de Vaporeon comienzan a vibrar, significa que llovera en las proximas horas.', 'Absorbe Agua'),
(135, 'Jolteon', 0.8, 'Relampago', 24.5, 'Si se enfada o asusta, se le eriza el pelaje. Cada uno de sus pelos se convierte en una afilada pua que hace trizas al rival.', 'Absorbe'),
(136, 'Flareon', 0.9, 'Llama', 25, 'Una vez que ha almacenado el calor suficiente, puede alcanzar una temperatura de 900 C.', 'Absorbe Fuego'),
(137, 'Porygon', 0.8, 'Virtual', 36.5, 'Se trata del primer Pokemon del mundo creado a partir de codigos de programacion gracias al uso de tecnologia de vanguardia.', 'Rastro'),
(138, 'Omanyte', 0.4, 'Espiral', 7.5, 'Varios ejemplares han escapado o bien han sido liberados tras su restauracion, lo que comienza a suscitar una serie de problemas.', 'Caparazon'),
(139, 'Omastar', 1, 'Espiral', 35, 'Se cree que se extinguio porque el excesivo tamano y peso de su concha le impedian moverse con rapidez para capturar presas.', 'Caparazon'),
(140, 'Kabuto', 0.4, 'Armazon', 11.5, 'Un Pokemon casi extinto. Cada tres dias, muda el caparazon, que se va endureciendo de forma progresiva.', 'Nado Rapido'),
(141, 'Kabutops', 1.3, 'Armazon', 40.5, 'Despedaza a las presas que atrapa para sorber sus fluidos y deja los restos para que otros Pokemon den buena cuenta de ellos.', 'Nado Rapido'),
(142, 'Aerodactyl', 1.8, 'Fosil', 59, 'Un feroz Pokemon de la epoca prehistorica al que no bastan todos los avances tecnologicos actuales para regenerar a la perfeccion.', 'Cabeza Roca'),
(143, 'Snorlax', 2.1, 'Dormir', 460, 'No se encuentra satisfecho hasta haber ingerido 400 kg de comida cada dia. Cuando acaba de comer, se queda dormido.', 'Sebo'),
(144, 'Articuno', 1.7, 'Congelar', 55.4, 'Se dice que sus bellas alas azules se componen de hielo. Vuela en torno a las montanas nevadas con su larga cola al viento.', 'Presion'),
(145, 'Zapdos', 1.6, 'Electrico', 52.6, 'Posee el poder de controlar la electricidad a su antojo. Segun la creencia popular, anida oculto en oscuros nubarrones de tormenta.', 'Presion'),
(146, 'Moltres', 2, 'Llama', 60, 'Una de las aves legendarias. Al batir las alas, las llamas que las envuelven emiten un hermoso fulgor rojo.', 'Presion'),
(147, 'Dratini', 1.8, 'Dragon', 3.3, 'Habita en orillas junto a fuertes corrientes de agua, como bajo cascadas. Muda la piel una y otra vez a medida que crece.', 'Mudar'),
(148, 'Dragonair', 4, 'Dragon', 16.5, 'Vive en lagos y mares de aguas cristalinas. Su poder para controlar el clima le permite alzar el vuelo llevado por el viento.', 'Mudar'),
(149, 'Dragonite', 2.2, 'Dragon', 210, 'Un Pokemon bondadoso y compasivo al que le resulta imposible dar la espalda a Pokemon o humanos que se encuentren a la deriva.', 'Foco Interno'),
(150, 'Mewtwo', 2, 'Genetico', 122, 'Su ADN es casi el mismo que el de Mew. Sin embargo, su tamano y caracter son muy diferentes.', 'Presion'),
(151, 'Mew', 0.4, 'Nueva Especie', 4, 'Si se observa a traves de un microscopio, puede distinguirse cuan corto, fino y delicado es el pelaje de este Pokemon.', 'Sicronia'),
(152, 'Chikorita', 0.9, 'Hoja', 6.4, 'Al luchar, Chikorita agita la hoja que tiene para mantener a raya al rival. Pero, al mismo tiempo, libera una suave fragancia que apacigua el encuentro y crea un ambiente agradable y de amistad.', 'Espesura'),
(153, 'Bayleef', 1.2, 'Hoja', 15.8, 'Bayleef tiene un collar de hojas alrededor del cuello y un brote de un arbol en cada una de ellas. La fragancia que desprenden estos brotes anima a la gente.', 'Espesura'),
(154, 'Meganium', 1.8, 'Hierba', 100.5, 'La fragancia de la flor de Meganium aplaca y suaviza los animos. Al luchar, este Pokemon libera mayor cantidad de esencia para disminuir el animo de combate de su oponente.', 'Espesura'),
(155, 'Cyndaquil', 0.5, 'Raton Fuego', 7.9, 'Cyndaquil se protege soltando llamas por el lomo. Cuando esta enfadado, las llamas son fieras, pero, si esta cansado, solo consigue echar algunas chispas que no llegan a cuajar en una completa combustion.', 'MAr LLAmas'),
(156, 'Quilava', 0.9, 'volcan', 19, 'Quilava mantiene a sus rivales a raya con la intensidad de sus llamas y las rafagas de aire igneo que producen. Tambien aprovecha su espectacular agilidad para esquivar ataques a la vez que abrasa al rival con sus llamas.', 'Mar llama'),
(157, 'Typhlosion', 1.7, 'Volcan', 79.5, 'Typhlosion se oculta tras un tremulo haz de calor que crea mediante sus intensas y sofocantes llamaradas. Este Pokemon causa explosiones de fuego que reducen todo a cenizas.', 'Mar Llamas'),
(158, 'Totodile', 0.6, 'Fauces', 9.5, 'Totodile tiene cuerpo pequeno, pero fuertes mandibulas. A veces, piensa que solo esta dando un mordisquito y hace unas heridas bastante considerables.', 'Torrente'),
(159, 'Croconaw', 1.1, 'Fauces', 25, 'Una vez que Croconaw le ha clavado los colmillos a su presa, es imposible que escape porque los tiene hacia adentro como si fueran anzuelos. Cuando Croconaw hinca los dientes, no hay escapatoria.\n\n', 'Torrente');

-- --------------------------------------------------------

--
-- Table structure for table `pokemon_tipos`
--

CREATE TABLE `pokemon_tipos` (
  `n_pokemon` int(11) NOT NULL,
  `idTipos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pokemon_tipos`
--

INSERT INTO `pokemon_tipos` (`n_pokemon`, `idTipos`) VALUES
(61, 0),
(81, 0),
(82, 0),
(7, 1),
(8, 1),
(9, 1),
(54, 1),
(55, 1),
(60, 1),
(62, 1),
(72, 1),
(73, 1),
(79, 1),
(80, 1),
(86, 1),
(87, 1),
(90, 1),
(91, 1),
(98, 1),
(99, 1),
(116, 1),
(117, 1),
(118, 1),
(119, 1),
(120, 1),
(121, 1),
(129, 1),
(130, 1),
(131, 1),
(134, 1),
(138, 1),
(139, 1),
(140, 1),
(141, 1),
(158, 1),
(159, 1),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(46, 2),
(47, 2),
(48, 2),
(49, 2),
(123, 2),
(127, 2),
(147, 3),
(148, 3),
(149, 3),
(25, 4),
(26, 4),
(81, 4),
(82, 4),
(100, 4),
(101, 4),
(125, 4),
(135, 4),
(145, 4),
(4, 5),
(5, 5),
(6, 5),
(37, 5),
(38, 5),
(58, 5),
(59, 5),
(77, 5),
(78, 5),
(126, 5),
(136, 5),
(146, 5),
(155, 5),
(156, 5),
(157, 5),
(35, 6),
(36, 6),
(39, 6),
(40, 6),
(122, 6),
(87, 7),
(91, 7),
(124, 7),
(131, 7),
(144, 7),
(56, 8),
(57, 8),
(62, 8),
(66, 8),
(67, 8),
(68, 8),
(106, 8),
(107, 8),
(16, 9),
(17, 9),
(18, 9),
(19, 9),
(20, 9),
(21, 9),
(22, 9),
(39, 9),
(40, 9),
(52, 9),
(53, 9),
(83, 9),
(84, 9),
(85, 9),
(108, 9),
(113, 9),
(115, 9),
(128, 9),
(132, 9),
(133, 9),
(137, 9),
(143, 9),
(1, 10),
(2, 10),
(3, 10),
(43, 10),
(44, 10),
(45, 10),
(46, 10),
(47, 10),
(69, 10),
(70, 10),
(71, 10),
(102, 10),
(103, 10),
(114, 10),
(152, 10),
(153, 10),
(154, 10),
(63, 11),
(64, 11),
(65, 11),
(79, 11),
(80, 11),
(96, 11),
(97, 11),
(102, 11),
(103, 11),
(121, 11),
(122, 11),
(124, 11),
(150, 11),
(151, 11),
(74, 12),
(75, 12),
(76, 12),
(95, 12),
(111, 12),
(112, 12),
(138, 12),
(139, 12),
(140, 12),
(141, 12),
(142, 12),
(27, 14),
(28, 14),
(31, 14),
(34, 14),
(50, 14),
(51, 14),
(74, 14),
(75, 14),
(76, 14),
(95, 14),
(104, 14),
(105, 14),
(111, 14),
(112, 14),
(1, 15),
(2, 15),
(3, 15),
(13, 15),
(14, 15),
(15, 15),
(23, 15),
(24, 15),
(29, 15),
(30, 15),
(31, 15),
(32, 15),
(33, 15),
(34, 15),
(41, 15),
(42, 15),
(43, 15),
(44, 15),
(45, 15),
(48, 15),
(49, 15),
(69, 15),
(70, 15),
(71, 15),
(72, 15),
(73, 15),
(88, 15),
(89, 15),
(92, 15),
(93, 15),
(94, 15),
(109, 15),
(110, 15),
(152, 15),
(6, 16),
(12, 16),
(16, 16),
(17, 16),
(18, 16),
(21, 16),
(22, 16),
(41, 16),
(42, 16),
(83, 16),
(84, 16),
(85, 16),
(123, 16),
(130, 16),
(142, 16),
(144, 16),
(145, 16),
(146, 16),
(149, 16),
(92, 17),
(93, 17),
(94, 17);

-- --------------------------------------------------------

--
-- Table structure for table `tipos`
--

CREATE TABLE `tipos` (
  `idTipos` int(11) NOT NULL,
  `Tipo` varchar(255) DEFAULT NULL,
  `TipoIco` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tipos`
--

INSERT INTO `tipos` (`idTipos`, `Tipo`, `TipoIco`) VALUES
(0, 'acero', 'https://static.wikia.nocookie.net/espokemon/images/d/d9/Tipo_acero.gif'),
(1, 'agua', 'https://static.wikia.nocookie.net/espokemon/images/9/94/Tipo_agua.gif'),
(2, 'bicho', 'https://static.wikia.nocookie.net/espokemon/images/f/fe/Tipo_bicho.gif'),
(3, 'dragon', 'https://static.wikia.nocookie.net/espokemon/images/0/01/Tipo_drag%C3%B3n.gif/'),
(4, 'electrico', 'https://static.wikia.nocookie.net/espokemon/images/1/1b/Tipo_el%C3%A9ctrico.gif'),
(5, 'fuego', 'https://static.wikia.nocookie.net/espokemon/images/c/ce/Tipo_fuego.gif\r\n'),
(6, 'hada', 'https://static.wikia.nocookie.net/espokemon/images/b/bc/Tipo_hada.gif'),
(7, 'hielo', 'https://static.wikia.nocookie.net/espokemon/images/4/40/Tipo_hielo.gif'),
(8, 'lucha', 'https://static.wikia.nocookie.net/espokemon/images/4/40/Tipo_hielo.gif'),
(9, 'normal', 'http://static.wikia.nocookie.net/espokemon/images/3/32/Tipo_normal.gif'),
(10, 'planta', 'https://static.wikia.nocookie.net/espokemon/images/d/d6/Tipo_planta.gif'),
(11, 'psiquico', 'https://static.wikia.nocookie.net/espokemon/images/1/15/Tipo_ps%C3%ADquico.gif'),
(12, 'roca', 'https://static.wikia.nocookie.net/espokemon/images/e/e0/Tipo_roca.gif'),
(13, 'siniestro', 'https://static.wikia.nocookie.net/espokemon/images/8/82/Tipo_siniestro.gif'),
(14, 'tierra', 'https://static.wikia.nocookie.net/espokemon/images/1/1d/Tipo_tierra.gif'),
(15, 'veneno', 'https://static.wikia.nocookie.net/espokemon/images/1/10/Tipo_veneno.gif'),
(16, 'volador', 'https://static.wikia.nocookie.net/espokemon/images/e/e1/Tipo_volador.gif'),
(17, 'fantasma', 'https://static.wikia.nocookie.net/espokemon/images/4/47/Tipo_fantasma.gif');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`usuario`);

--
-- Indexes for table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`n_pokemon`);

--
-- Indexes for table `pokemon_tipos`
--
ALTER TABLE `pokemon_tipos`
  ADD PRIMARY KEY (`n_pokemon`,`idTipos`),
  ADD KEY `idTipos_idx` (`idTipos`);

--
-- Indexes for table `tipos`
--
ALTER TABLE `tipos`
  ADD PRIMARY KEY (`idTipos`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pokemon_tipos`
--
ALTER TABLE `pokemon_tipos`
  ADD CONSTRAINT `idTipos` FOREIGN KEY (`idTipos`) REFERENCES `tipos` (`idtipos`),
  ADD CONSTRAINT `n_pokemon` FOREIGN KEY (`n_pokemon`) REFERENCES `pokemon` (`n_pokemon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
