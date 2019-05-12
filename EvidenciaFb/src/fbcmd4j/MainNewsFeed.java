/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbcmd4j;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

/**
 *
 * @author Fernando Gutierrez Arevalo   2828960
 */
public class MainNewsFeed extends JFrame {
    public static void main (String[] args) throws FacebookException{
        // https://facebook4j.github.io/en/code-examples.html no esta soportado oficialmente por facebook :C
        //hay que saber el ID de la pagina de facebook... y hay que tener un token generado por la creacion de una app
            //identificador de mi pagina NEON 364006917447705
            //las aplicaciones de fb4j sirve para paginas de fan, o de un grupo
            //no es para perfiles , solo para paginas
            //este de abajo  es mi ID
            // fbid=1931533110308481    &set=a.102183059910171&type=3&source=11&referrer_profile_id=100003554314507
            
            Scanner res = new Scanner(System.in);   //res del resultado de la opcion, del switch case... lol para diferenciar scanners
            int o = 1;
        while(o != 0) {
            //
            try {
            Facebook facebook = new FacebookFactory().getInstance();
            //id de la App, clave secreta de la app hexadecimal, respectivament
            facebook.setOAuthAppId("319117058766047", "092e937a82c2d215fb461b91c687b393");
            //necesito un tokenazo
            String accessTokenString = "EAAEiPDrt9N8BAOtvbVWWP0U13z7ZAZBfDzkpOQeG7oscm0lbzPylOE36BDBboylTUUs3ZBNLjvpFZCZBW1XwriIO3EeOgURaAMPIQl5OZCOA3RyEQ8HZCfAY1gzZAhCajwGoFDtZBeCFMd5lX9HVr1U9n0LqWtgfrpaBka75hZCWxIzAZDZD";
            AccessToken at = new AccessToken(accessTokenString);
            
            facebook.setOAuthAccessToken(at);
            //No funcionó porque requiere que la aplicación esté instalada en un grupo
            //facebook.postLink(new URL("https://facebook4j.github.io"));
            //facebook.postStatusMessage("Aquí testeando Facebook4J, saludos!");
            //getFeed(idPagina, numero de post a ver)
            Scanner sc = new Scanner(System.in);
                        System.out.println("APP de facebook");
			System.out.println("===================================");
			System.out.println("Para revisar los newsfeed      : 1");
			System.out.println("Para obtener el wall           : 2");
			System.out.println("Para postear un comentario     : 3");
                        System.out.println("Politicas de privacidad        : 4");
                        System.out.println("Para salir                     : 0");
			System.out.println("===================================");
            switch (o  = sc.nextInt())
            { 
                case 1: 
                     ResponseList<Post> feeds = facebook.getFeed("643651589393111", new Reading().limit(25)); 
             FileWriter file = new FileWriter("./salida.txt");
             BufferedWriter fos = new BufferedWriter(file); //fos de FileOutputStream
            
            for (int i = 0; i < feeds.size(); i++) {
                Post post = feeds.get(i);
                String message = post.getMessage();
                System.out.println(message);
                if (message != null)
                fos.write(message + "\n\r");
                else
                    fos.write("null" + "\n\r");
            }
                    break;
                    
                case 2:
                    
                        ResponseList<Post> feedse = facebook.getFeed("643651589393111", new Reading().limit(25)); 
                        FileWriter filee = new FileWriter("./salidaw.txt");
                       fos = new BufferedWriter(filee); //fos de FileOutputStream
                       try {
                         feeds = facebook.getHome();
                      } catch (Exception e) {
                            fos.write(e + "\n\r"); }
                     try {
                    facebook.postStatusMessage("Aqui testeando facebbok4J, saludos");
                        } catch (FacebookException e) {
                            fos.write(e + "\n\r");
                               }
                         for (int i = 0; i < feedse.size(); i++) 
                                {
                                     Post post = feedse.get(i);
                                      String message = post.getMessage();
                                    System.out.println(message);
                            if (message != null)
                                  fos.write(message + "\n\r");
                            else
                                    fos.write("null" + "\n\r");
                                         }
                                     fos.close();
                     break;
                     
                 //Página Javalandia  @finionio
            case 3:
                facebook.postStatusMessage("Hola pues, para todos los nerdos");
            break;
            //Falla al querer cambiarse al muro
            case 0: 
                System.exit(0);
                break;
            case 4:
                System.out.println("politicasdeprivacidadfb.xhtml");
                new MainNewsFeed().start();
                break;
            default:
                
                System.out.println("Error en la selección, vuelva a intentarlo"); 
                break;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MainNewsFeed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
} 
public void start(){
try { String html; 
html="<html><head><title>Simple Page</title></head>"; 
html+="<body bgcolor='#777779'><hr/><font size=12>    Política de privacidad de Facebook\n" +
"per Facebook Site Governance\n" +
"Política de privacidad de Facebook\n" +
"1. Introducción\n" +
"Preguntas. Si tienes alguna pregunta o duda sobre nuestra política de privacidad, ponte en\n" +
"contacto con nuestro equipo de privacidad a través de esta página de ayuda. También\n" +
"puedes contactar con nosotros por correo ordinario en 76146,Queretaro, queretaro\n" +
"Programa TRUSTe. Facebook es titular de una licencia de certificación del programa de\n" +
"privacidad TRUSTe. Esto significa que nuestra política y nuestras prácticas han sido\n" +
"supervisadas por TRUSTe, una organización independiente dedicada a comprobar las\n" +
"políticas y prácticas de privacidad y seguridad para garantizar que cumplen los estrictos\n" +
"requisitos de su programa. Esta política de privacidad se aplica al sitio web\n" +
"www.facebook.com. El programa TRUSTe sólo incluye la información recopilada a través de\n" +
"este sitio web, y no comprende otros datos, como información que pudiera recopilarse a\n" +
"través de software descargado de Facebook.\n" +
"Si tienes alguna queja sobre nuestra política o nuestras prácticas, infórmanos a través de\n" +
"esta página de ayuda. Si no te satisface nuestra respuesta, puedes ponerte en contacto con\n" +
"TRUSTe.\n" +
"Safe Harbor. Facebook también participa en el marco Safe Harbor desarrollado por el\n" +
"Departamento de Comercio de Estados Unidos y la Unión Europea. Como parte de nuestra\n" +
"participación en Safe Harbor, nos comprometemos a resolver todos los posibles conflictos\n" +
"que puedan surgir en relación con nuestras políticas y prácticas a través de TRUSTe. Para\n" +
"ver nuestra certificación, entra en el sitio web del programa Safe Harbor del Departamento\n" +
"de Comercio de los Estados Unidos.\n" +
"Ámbito. La presente política de privacidad incluye Facebook al completo. No obstante, no\n" +
"es aplicable a entidades que no sean propiedad o no se encuentren bajo el control de\n" +
"Facebook, incluidos los sitios web y aplicaciones que utilicen la plataforma. Si utilizas o\n" +
"accedes a Facebook, estarás aceptando las prácticas de privacidad aquí definidas.\n" +
"No se acepta información de niños menores de 13 años. Si tienes menos de 13 años, no\n" +
"intentes registrarte en Facebook ni nos facilites ningún dato personal. Si descubrimos que\n" +
"hemos recibido información de un niño menor de 13 años, borraremos esa información lo\n" +
"más rápido posible. Si crees que podría obrar en nuestro poder información procedente de\n" +
"un niño menor de 13 años, ponte en contacto con nosotros a través de esta página de\n" +
"ayuda.\n" +
"Participación de los padres. Recomendamos encarecidamente que los menores de 13 años\n" +
"de edad o más pidan permiso a sus padres antes de enviar información sobre sí mismos a\n" +
"través de internet, y animamos a los padres a que enseñen a sus hijos prácticas seguras\n" +
"para el uso de internet. Encontrarás material de ayuda acerca de cómo los padres pueden\n" +
"hablar con sus hijos sobre un uso seguro de internet en esta página de ayuda.\n" +
"2. Información que recibimos\n" +
"Información que nos envías:\n" +
"Información sobre ti. Cuando te registras en Facebook, nos facilitas tu nombre, correo\n" +
"electrónico, sexo y fecha de nacimiento. Durante el proceso de registro, te ofrecemos la\n" +
"posibilidad de conectarte a tus amigos, centros educativos y empleados. También podrás\n" +
"añadir una foto. En algunos casos podríamos pedirte información adicional por motivos de\n" +
"seguridad o para ofrecerte servicios específicos. Una vez registrado puedes proporcionar \n" +
"otra información sobre ti relacionada, por ejemplo, con tu ciudad de residencia, ciudad de\n" +
"origen, familia, relaciones, redes, actividades, intereses y lugares. También puedes\n" +
"proporcionar información personal sobre ti, como tus tendencias políticas y religiosas.\n" +
"Contenido. Una de las finalidades principales del uso de Facebook es compartir contenido\n" +
"con los demás, por ejemplo, actualizar tu estado, cargar o hacer una foto, cargar o grabar\n" +
"un vídeo, compartir un enlace, crear un evento o un grupo, hacer un comentario, escribir\n" +
"algo en el muro de alguien, escribir una nota o enviar un mensaje. Si no deseas que\n" +
"guardemos los metadatos asociados al contenido que compartes en Facebook (como las\n" +
"fotografías) elimina los metadatos antes de cargar el contenido.\n" +
"Información sobre transacciones. Podemos guardar los datos de las transacciones o pagos\n" +
"que realices a través de Facebook. Si no deseas que almacenemos el número de cuenta de\n" +
"origen de tu pago, puedes eliminarlo a través de la página de pagos.\n" +
"Información sobre amigos. Te ofrecemos herramientas de importación de contactos para\n" +
"ayudarte a cargar las direcciones de tus amigos para que puedas encontrarles en Facebook\n" +
"e invitar a unirse a aquellos contactos que todavía no usen Facebook. Si no deseas que\n" +
"almacenemos esta información, entra en esta página de ayuda. Si nos das tu contraseña\n" +
"para obtener estos contactos, no la guardaremos una vez cargada la información de los\n" +
"contactos.\n" +
"Información que recopilamos cuando interactúas con Facebook:\n" +
"Información sobre la actividad en el sitio web. Realizamos un seguimiento de las acciones\n" +
"que llevas a cabo en Facebook, como añadir conexiones (incluido unirte a un grupo o añadir\n" +
"un amigo), crear un álbum de fotos, enviar un regalo, dar un toque a otro usuario, indicar\n" +
"que \"te gusta\" una publicación, asistir a un evento o conectarte a una aplicación. En\n" +
"algunos casos, también estás llevando a cabo una acción cuando nos proporcionas\n" +
"información o contenido. Por ejemplo, si compartes un vídeo, además de almacenar el\n" +
"contenido real que has actualizado, podemos registrar el hecho de que lo hayas\n" +
"compartido.\n" +
"Acceso a la información del dispositivo y del navegador. Cuando accedes a Facebook\n" +
"desde un ordenador, teléfono móvil u otro dispositivo, podemos obtener información de\n" +
"dicho dispositivo sobre tu tipo de navegador, ubicación y dirección IP, así como las páginas\n" +
"que visitas.\n" +
"Información sobre cookies. Utilizamos \"cookies\" (datos que almacenamos en tu ordenador,\n" +
"teléfono móvil u otro dispositivo durante un período de tiempo prolongado) para que\n" +
"Facebook sea más fácil de usar, para que nuestra publicidad sea mejor y para proteger\n" +
"tanto a ti como a Facebook. Por ejemplo, las empleamos para guardar tu nombre de\n" +
"usuario (pero nunca tu contraseña) de modo que te resulte más sencillo iniciar sesión cada\n" +
"vez que quieras entrar en Facebook. También utilizamos las cookies para confirmar que\n" +
"estás conectado a Facebook, y para saber cuándo estás interactuando con aplicaciones y\n" +
"sitios web de la plataforma Facebook, nuestros widgets, botones de compartir y nuestros\n" +
"anuncios. Puedes eliminar o bloquear las cookies mediante la configuración de tu\n" +
"navegador, pero en algunos casos puede influir en tu capacidad de uso de Facebook.\n" +
"Información que recibimos de terceros:\n" +
"Plataforma de Facebook. No poseemos ni operamos las aplicaciones o sitios web que\n" +
"utilizas a través de la plataforma de Facebook (como juegos y otros programas). Cuando te\n" +
"conectes a un sitio web o una aplicación de la plataforma, nos suministrarán información,\n" +
"incluida la información acerca de las acciones que realizas. En algunos casos, es posible que\n" +
"recibamos una cantidad limitada de información antes de que te conectes a la aplicación o\n" +
"sitio web para poder personalizar el proceso de conexión.\n" +
"Información procedente de otros sitios web. Podemos establecer programas con socios\n" +
"publicitarios y otros sitios web en los que éstos comparten información con nosotros: \n" +
"- Podemos solicitar a los anunciantes que nos indiquen cómo nuestros usuarios han\n" +
"respondido a los anuncios que les mostramos (y, con fines comparativos, cómo han actuado\n" +
"en su página otros usuarios que no habían visto los anuncios). Esta compartición de datos,\n" +
"denominada comúnmente \"seguimiento de conversión\" nos ayuda a medir la efectividad de\n" +
"nuestra publicidad y a mejorar la calidad de los anuncios que ves.\n" +
"- Podemos recibir información sobre si has visto o no, o si has interactuado con\n" +
"determinados anuncios de otros sitios, para medir la efectividad de dichos anuncios.\n" +
"Si en cualquiera de estos casos recibimos datos que todavía no tenemos, les otorgaremos el\n" +
"carácter de \"anónimos\" en un plazo de 180 días, lo cual significa que no asociaremos la\n" +
"información con ningún usuario en particular. Si establecemos dichos programas, sólo\n" +
"haremos uso de la información según se explica en la sección \"Cómo utilizamos tu\n" +
"información\" expuesta a continuación.\n" +
"Información procedente de otros usuarios. Podemos recopilar información acerca de ti a\n" +
"partir de otros usuarios de Facebook (como cuando un amigo te etiqueta en una foto, un\n" +
"vídeo o un lugar, proporciona detalles de vuestra amistad o indica su relación contigo).\n" +
"3. Compartir información en Facebook.\n" +
"En esta sección se explica cómo funciona la configuración de privacidad y cómo se\n" +
"comparte tu información en Facebook. Antes de compartir información en Facebook debes\n" +
"tener en cuenta tu configuración de privacidad.\n" +
"Nombre y fotografía de perfil. Facebook ha sido diseñado para que te resulte sencillo\n" +
"encontrar y conectarte a otros. Por este motivo, tu nombre y fotografía de perfil carecen\n" +
"de configuración de privacidad. Si no quieres compartir tu fotografía de perfil, debes\n" +
"eliminarla (o no añadir ninguna). También puedes controlar quién puede encontrarte al\n" +
"buscar en Facebook o en motores de búsqueda públicos utilizando la configuración de\n" +
"búsqueda.\n" +
"Información de contacto. La configuración de tu información de contacto controla quién\n" +
"puede ponerse en contacto contigo en Facebook y quién puede ver tu información de\n" +
"contacto (por ejemplo, tu dirección de correo electrónico y número de teléfono). Recuerda\n" +
"que esta información no es obligatoria (excepto la dirección de correo electrónico) y no\n" +
"tienes por qué compartir tu dirección de correo electrónico con nadie.\n" +
"Información personal. La configuración de tu información personal controla quién puede\n" +
"ver tu información personal (por ejemplo, tus tendencias políticas y religiosas) si decides\n" +
"añadirla. Recomendamos compartir esta información utilizando la opción \"amigos de mis\n" +
"amigos\".\n" +
"Mis publicaciones. Puedes seleccionar una configuración de privacidad para cada\n" +
"publicación que realices usando el editor de nuestro sitio. Tanto si vas a cargar una foto\n" +
"como a publicar una actualización de estado, puedes controlar exactamente quién puede\n" +
"verla en el momento de crearlo. Cada vez que compartas algo, busca el icono del candado.\n" +
"Si haces clic en el candado se mostrará un menú que te permite elegir quién podrá ver tu\n" +
"publicación. Si decides no seleccionar tu configuración en el momento de publicar el\n" +
"contenido, dicho contenido se compartirá en consonancia con la configuración de\n" +
"privacidad de Mis publicaciones.\n" +
"Conexiones. Facebook permite conectarte prácticamente a cualquier persona o cosa que\n" +
"desees, desde amigos y familiares hasta la ciudad donde resides o los restaurantes que te\n" +
"gusta visitar y tus grupos y películas preferidos. Puesto que hacen falta dos para\n" +
"conectarse, tu configuración de privacidad sólo controla quién puede ver la conexión en tu\n" +
"página de perfil. Si te incomoda que tu conexión esté disponible públicamente, deberías\n" +
"eliminarla \n" +
"Sexo y fecha de nacimiento. Además del nombre y la dirección de correo electrónico,\n" +
"requerimos que nos facilites tu sexo y fecha de nacimiento durante el proceso de registro.\n" +
"Te pedimos la fecha de nacimiento para comprobar que eres mayor de 13 años y, así, poder\n" +
"limitar mejor el acceso a contenidos y anuncios que no sean adecuados para ciertas edades.\n" +
"Puesto que tu fecha de nacimiento y sexo son obligatorios, no puedes eliminarlos. Sin\n" +
"embargo, puedes editar tu perfil para ocultar todo (o parte) de dichos campos para que no\n" +
"los vean otros usuarios.\n" +
"Otros. Otras indicaciones que debes recordar:\n" +
"- Parte del contenido que compartes y de las acciones que llevas a cabo se mostrarán en las\n" +
"páginas de inicio de tus amigos y en otras páginas que visiten.\n" +
"- Si otro usuario te etiqueta en una foto, vídeo o lugar, puedes eliminar la etiqueta.\n" +
"También puedes limitar quién puede ver que has sido etiquetado en tu perfil desde la\n" +
"configuración de privacidad.\n" +
"- Incluso después de eliminar información de tu perfil o eliminar tu cuenta, pueden\n" +
"permanecer copias de dicha información visible en otro lugar en la medida en que se haya\n" +
"compartido con otros, se haya distribuido de otro modo conforme a tu configuración de\n" +
"privacidad, o haya sido copiada o almacenada por otros usuarios.\n" +
"-Debes entender que la información puede ser compartida a su vez o copiada por otros\n" +
"usuarios.\n" +
"-Algunos tipos de comunicaciones que envías a otros usuarios no pueden eliminarse, como\n" +
"por ejemplo los mensajes.\n" +
"- Cuando publicas información en el perfil de otro usuario o realizas un comentario en la\n" +
"publicación de otro usuario, dicha información queda sujeta a la configuración de\n" +
"privacidad del otro usuario.\n" +
"-Si utilizas una fuente externa para publicar información en Facebook (como una aplicación\n" +
"móvil o un sitio web de Connect) debes comprobar la configuración de privacidad de dicha\n" +
"publicación, puesto que la establece la fuente externa.\n" +
"Información de “Todos”. La información configurada como “todos” está disponible\n" +
"públicamente, como tu nombre, foto de perfil y conexiones. Dicha información permanece\n" +
"accesible y visible para todo aquel que entre en Internet (incluidas las personas no\n" +
"registradas en Facebook), queda sujeta a indexación por parte de motores de búsqueda de\n" +
"terceros y puede ser importada, exportada, distribuida y redistribuida por nosotros y otros\n" +
"sin limitaciones de privacidad. Dicha información puede asociarse contigo, incluido tu\n" +
"nombre y fotografía de perfil, incluso fuera de Facebook, por ejemplo, en motores de\n" +
"búsqueda públicos y cuando visites otros sitios de Internet. La configuración de privacidad\n" +
"predeterminada para ciertos tipos de información que publicas en Facebook está\n" +
"establecida en “todos”. Puedes revisar y modificar la configuración predeterminada en tu\n" +
"configuración de privacidad. Si eliminas el contenido compartido con \"todos\" previamente\n" +
"publicado en Facebook, lo borraremos de tu perfil de Facebook, pero no podemos controlar\n" +
"su uso fuera de Facebook.\n" +
"Menores. Nos reservamos el derecho de aplicar métodos de protección especial para\n" +
"menores (como proporcionarles un contenido adecuado a su edad) y aplicar restricciones a\n" +
"la capacidad que tienen los adultos para compartir y conectarse a menores, reconociendo\n" +
"que esto puede suponer para los menores una experiencia más limitada en Facebook.\n" +
"4. Información que compartes con terceros.\n" +
"Plataforma de Facebook. Como ya hemos mencionado, no operamos los sitios web y\n" +
"aplicaciones que utilizan la plataforma de Facebook ni somos sus propietarios. Esto significa\n" +
"que al utilizar estas aplicaciones y sitios web, tu información de Facebook no está sólo \n" +
"disponible para Facebook. Antes de permitir el acceso a cualquier información sobre ti, les\n" +
"requerimos que acepten una serie de condiciones que limitan su uso de tu información\n" +
"(puedes consultar estas condiciones en la sección 9 de nuestra Declaración de derechos y\n" +
"responsabilidades) y ponemos en práctica medidas técnicas para garantizar que sólo\n" +
"obtienen información autorizada. Para obtener más información sobre la plataforma, visita\n" +
"la página Acerca de la plataforma.\n" +
"Conexión a una aplicación o sitio web. Cuando te conectas a una aplicación o sitio web,\n" +
"éstos tendrán acceso a Información general sobre ti. El término Información general incluye\n" +
"tu nombre y los nombres de tus amigos, fotografías de perfil, sexo, identificador de\n" +
"usuario, conexiones y cualquier contenido compartido usando la configuración de\n" +
"privacidad “Todos”. Para ayudar a estos sitios web y aplicaciones a poner en práctica\n" +
"medidas de seguridad y controlar la distribución de contenido apropiado a usuarios de\n" +
"diferentes edades, podemos poner a su disposición información sobre la localización de tu\n" +
"equipo informático o dispositivo de acceso, así como tu edad. Si la aplicación o el sitio web\n" +
"desea acceder a otros datos, tendrá que pedirte permiso.\n" +
"Te proporcionamos herramientas para controlar cómo compartir tu información con\n" +
"aplicaciones y sitios web que utilicen la plataforma. Por ejemplo, puedes bloquear el\n" +
"acceso de aplicaciones específicas a tu información en la configuración de las aplicaciones\n" +
"o en la página “Acerca de” de la aplicación. También puedes utilizar tu configuración de\n" +
"privacidad para limitar qué parte de tu información está disponible para “todos”.\n" +
"Aconsejamos que leas siempre las políticas de los sitios web y las aplicaciones de terceros\n" +
"para cerciorarte de que estás de acuerdo con el modo en el que usan la información que\n" +
"compartes con ellos. Facebook no puede garantizar que estos sitios web o aplicaciones\n" +
"cumplirán nuestras normas. Si encuentras alguna aplicación o sitio web que infringe\n" +
"nuestras normas, infórmanos de este incumplimiento en esta página de ayuda y tomaremos\n" +
"las medidas oportunas.\n" +
"Cuando tus amigos utilizan la plataforma. Si tu amigo se conecta a una aplicación o sitio\n" +
"web, éstos podrán acceder a tu nombre, fotografía de perfil, sexo, ID de usuario y aquella\n" +
"información que hayas compartido con “todos”. También podrán acceder a tus conexiones,\n" +
"pero no podrán acceder a tu lista de amigos. Si ya te has conectado a ese sitio web o\n" +
"aplicación (o dispones de otra cuenta en estos lugares), es posible que éstos también\n" +
"puedan conectarse con tu amigo a través de ese sitio web o aplicación. Si la aplicación o el\n" +
"sitio web desean acceder a cualquier otro contenido o información tuya (incluida tu lista de\n" +
"amigos), tendrá que obtener permiso específico de tu amigo. Si tu amigo concede permiso\n" +
"a la aplicación o al sitio web, sólo podrán acceder a contenido e información sobre ti a la\n" +
"que tu amigo pueda acceder. Además, sólo podrán utilizar dicho contenido y dicha\n" +
"información en conexión con ese amigo. Por ejemplo, si un amigo facilita a una aplicación\n" +
"acceso a una fotografía que sólo compartes con tus amigos, dicha aplicación puede permitir\n" +
"a tu amigo ver o imprimir la fotografía, pero no puede mostrársela a nadie más.\n" +
"Te proporcionamos una serie de herramientas para controlar cómo se comparte tu\n" +
"información cuando tu amigo se conecta a una aplicación o sitio web. Por ejemplo, puedes\n" +
"utilizar tu configuración de privacidad de las aplicaciones para limitar qué información\n" +
"pueden poner tus amigos a disposición de las aplicaciones y los sitios web. También puedes\n" +
"bloquear aplicaciones o sitios web particulares para que no accedan a tu información.\n" +
"Puedes utilizar tu configuración de privacidad para limitar los amigos que pueden acceder a\n" +
"tu información o limitar qué parte de tu información está disponible para “todos”. También\n" +
"puedes desconectarte de un amigo si no estás de acuerdo con el modo en que utiliza tu\n" +
"información.\n" +
"Sitios web y aplicaciones de terceros aprobados previamente. Para proporcionarte\n" +
"experiencias sociales útiles fuera de Facebook, en ocasiones necesitamos proporcionar\n" +
"Información general sobre ti a sitios web y aplicaciones de terceros aprobados previamente\n" +
"que utilicen la plataforma cuando los visites (si aún tienes una sesión iniciada en\n" +
"Facebook). Del mismo modo, cuando uno de tus amigos visita un sitio web o aplicación\n" +
"aprobados previamente, recibirá información general sobre ti para que podáis conectaros \n" +
"también a través de ese sitio web (si también dispones de una cuenta en dicho sitio web).\n" +
"En estos casos, requerimos que estos sitios web y estas aplicaciones se sometan a un\n" +
"proceso de aprobación y participen en diferentes acuerdos con el objetivo de proteger tu\n" +
"privacidad. Por ejemplo, estos acuerdos incluyen disposiciones relativas al acceso y\n" +
"eliminación de tu Información general, así como la posibilidad de rechazar la participación\n" +
"en la experiencia ofrecida. También puedes eliminar cualquier sitio web o aplicación\n" +
"aprobados previamente que hayas visitado aquí, o bloquear todos los sitios web y\n" +
"aplicaciones aprobados previamente para que no obtengan información general sobre ti\n" +
"cuando los visites aquí. Además, si cierras la sesión de Facebook antes de visitar un sitio\n" +
"web o aplicación aprobados previamente, éstos no podrán acceder a tu información.\n" +
"Puedes ver una lista completa de sitios web aprobados previamente en nuestra página\n" +
"Acerca de la Plataforma.\n" +
"Exportación de información. Puedes (al igual que todos aquellos a cuya disposición has\n" +
"puesto tu información) utilizar herramientas como fuentes RSS, aplicaciones de libretas de\n" +
"direcciones del teléfono móvil o funciones de copiar y pegar para obtener y exportar (y en\n" +
"algunos casos importar) información de Facebook, incluida tu propia información y todos los\n" +
"datos sobre tu persona. Por ejemplo, si compartes tu número de teléfono con tus amigos,\n" +
"éstos pueden utilizar aplicaciones de terceros para sincronizar dicha información con la\n" +
"libreta de direcciones de sus teléfonos móviles.\n" +
"Publicidad. En ocasiones, los anunciantes que presentan publicidad en Facebook emplean\n" +
"métodos tecnológicos para medir la efectividad de sus anuncios y personalizar el contenido\n" +
"publicitario. Puedes renunciar a la fijación de cookies de numerosos anunciantes haciendo\n" +
"clic aquí. También puedes usar la configuración de cookies de tu navegador para limitar o\n" +
"evitar la fijación de cookies por parte de redes publicitarias.\n" +
"Enlaces. Al hacer clic en algunos enlaces de Facebook, es posible que te lleven fuera de\n" +
"nuestro sitio web. No nos hacemos responsables de las políticas de privacidad de otros\n" +
"sitios web, y te animamos a que leas sus normas de privacidad.\n" +
"5. Cómo utilizamos tu información\n" +
"Utilizamos la información que recopilamos para tratar de ofrecerte una experiencia segura,\n" +
"eficaz y personalizada. A continuación, incluimos algunos datos sobre cómo lo hacemos:\n" +
"Para gestionar el servicio. Utilizamos la información que recopilamos para ofrecerte\n" +
"nuestros servicios y funciones, evaluarlos y mejorarlos y prestarte servicio técnico.\n" +
"Empleamos la información para impedir actividades que podrían ser ilegales y aplicar\n" +
"nuestra Declaración de derechos y responsabilidades. También utilizamos una serie de\n" +
"sistemas tecnológicos para detectar y ocuparnos de actividades y contenido en pantalla\n" +
"anómalos con el fin de evitar abusos como el correo basura. Estos esfuerzos pueden\n" +
"provocar, en ocasiones, el fin o la suspensión temporal o permanente de algunas funciones\n" +
"para algunos usuarios.\n" +
"Para ponernos en contacto contigo. Ocasionalmente, podemos ponernos en contacto\n" +
"contigo para informarte de anuncios relativos a servicios. Puedes optar por no recibir\n" +
"ninguna comunicación salvo actualizaciones esenciales en la página de notificaciones de la\n" +
"cuenta>. En los mensajes de correo electrónico que te enviemos, podemos incluir\n" +
"contenido que veas en Facebook.\n" +
"Para ofrecerte anuncios personalizados. No compartimos información tuya con\n" +
"anunciantes sin tu consentimiento. (Un ejemplo de consentimiento sería que nos pidieses\n" +
"que suministrásemos tu dirección de envío a un anunciante para recibir una muestra\n" +
"gratuita.) Permitimos a los anunciantes elegir las características de los usuarios que verán\n" +
"sus anuncios y podemos utilizar cualquiera de los atributos que hayamos recabado que no\n" +
"te identifiquen personalmente (como información que puedas haber decidido no mostrar a\n" +
"otros usuarios, por ejemplo, el año de nacimiento) para seleccionar el público apropiado\n" +
"para dichos anuncios. Por ejemplo, podríamos utilizar tu interés por el fútbol para\n" +
"mostrarte anuncios de equipamiento de fútbol, pero no le decimos a la empresa que vende \n" +
"el equipamiento quién eres. Puedes consultar los criterios que pueden seleccionar los\n" +
"anunciantes visitando nuestra página de publicidad. Aunque no compartimos tu información\n" +
"con anunciantes sin tu consentimiento, cuando hagas clic en un anuncio o interactúes de\n" +
"otro modo con éste, existe la posibilidad de que el anunciante pueda colocar una cookie en\n" +
"tu navegador y tomar nota de que cumple los criterios que ha seleccionado.\n" +
"Para ofrecer anuncios sociales. En ocasiones, emparejamos los anuncios que ofrecemos\n" +
"con información pertinente que poseemos sobre ti y sobre tus amigos para que los anuncios\n" +
"resulten más interesantes y se adapten mejor a ti y a tus amigos. Por ejemplo, si te\n" +
"conectas a la página de tu grupo de música favorito, podemos mostrar tu nombre y la foto\n" +
"de tu perfil al lado de un anuncio de dicha página que verán tus amigos. Sólo compartimos\n" +
"la información personal visible en el anuncio social con el amigo que puede ver el anuncio.\n" +
"Puedes optar por que tu información no sea utilizada en anuncios sociales en esta página de\n" +
"ayuda.\n" +
"Para complementar tu perfil. Podemos utilizar información acerca de ti que recabemos de\n" +
"otros usuarios de Facebook para completar tu perfil (por ejemplo, cuando se te etiqueta en\n" +
"una foto o se te menciona en una actualización de estado). En tales casos, generalmente te\n" +
"permitimos eliminar el contenido (por ejemplo, permitiéndote eliminar la etiqueta de una\n" +
"foto tuya) o limitar la visibilidad de tu perfil.\n" +
"Para hacer sugerencias. Utilizamos la información de tu perfil, las direcciones que\n" +
"importas a través de las herramientas de importación de contactos y otra información\n" +
"pertinente para ayudarte a conectar con tus amigos, lo que incluye hacerte sugerencias a ti\n" +
"y a otros usuarios con los que conectes en Facebook. Por ejemplo, si otro usuario importa\n" +
"la misma dirección de correo electrónico que tú, podemos sugerir que os conectéis entre\n" +
"vosotros. Si quieres limitar tu visibilidad en las sugerencias que realizamos a otras\n" +
"personas, puedes ajustar la configuración de privacidad de visibilidad de búsqueda, ya que\n" +
"sólo estarás visible en nuestras sugerencias en la medida en que elijas estarlo en el\n" +
"resultado público de la búsqueda. También puedes bloquear a usuarios específicos para que\n" +
"no se te realicen sugerencias de ellos o para que no se les realicen sugerencias tuyas a\n" +
"ellos.\n" +
"Para ayudar a tus amigos a encontrarte. Permitimos a otros usuarios utilizar información\n" +
"de contacto que tengan sobre ti (como tu dirección de correo electrónico) para\n" +
"encontrarte, incluso a través de herramientas de importación y búsqueda de contactos.\n" +
"Puedes impedir que otros usuarios utilicen tu dirección de correo electrónico para\n" +
"encontrarte usando tu configuración de búsqueda.\n" +
"Software descargable. Algunas aplicaciones de software descargables y applets que\n" +
"ofrecemos, como las barras de herramientas del navegador y las herramientas para cargar\n" +
"fotos, nos transmiten datos. Podemos no realizar ninguna declaración formal si creemos\n" +
"que la recopilación y uso de información por nuestra parte es el fin obvio de la aplicación,\n" +
"por ejemplo, el hecho de recibir fotografías cuando se utiliza la herramienta para cargar\n" +
"fotos. Si creemos que no resulta obvio que estemos recopilando o utilizando dicha\n" +
"información, te avisaremos la primera vez que nos facilites la información, de tal manera\n" +
"que puedas decidir si deseas utilizar esa función.\n" +
"Cuentas in memoriam. Si se nos notifica que un usuario ha fallecido, podemos convertir su\n" +
"cuenta en una cuenta in memoriam. En tales casos, restringimos el acceso al perfil a los\n" +
"amigos confirmados y permitimos a éstos y a los familiares que escriban en el muro del\n" +
"usuario en recuerdo suyo. Podemos cerrar una cuenta si recibimos una solicitud formal de\n" +
"un pariente del usuario u otra solicitud legal pertinente para hacerlo.\n" +
"6. Cómo compartimos información\n" +
"Facebook se basa en compartir información con otros (amigos y miembros de tus redes) al\n" +
"tiempo que te ofrece una configuración de privacidad que puedes utilizar para restringir el\n" +
"acceso de otros usuarios a tu información. Compartimos tu información con terceros cuando\n" +
"creemos que dicha acción está permitida por ti, que es razonablemente necesaria para \n" +
"ofrecer nuestros servicios o cuando se nos exige legalmente que lo hagamos. Por ejemplo:\n" +
"Cuando realizas un pago. Cuando realices transacciones con otras personas o efectúes\n" +
"pagos en Facebook, sólo compartiremos la información de la transacción con los terceros\n" +
"que sean necesarios para completar la transacción. Requeriremos que los terceros acuerden\n" +
"respetar la privacidad de la información.\n" +
"Cuando invitas a un amigo a que se una a Facebook. Cuando nos pides que invitemos a un\n" +
"amigo a que se una a Facebook, le enviaremos un mensaje de tu parte, usando tu nombre.\n" +
"La invitación también puede contener información sobre otros usuarios que tu amigo pueda\n" +
"conocer. También le enviamos hasta dos recordatorios en tu nombre. Puedes ver quién ha\n" +
"aceptado tus invitaciones, enviar recordatorios y eliminar las direcciones de correo\n" +
"electrónico de tus amigos en la página del historial de invitaciones. Si tu amigo no quiere\n" +
"que conservemos su información, la eliminaremos a petición suya en esta página de ayuda.\n" +
"Cuando eliges compartir tu información con comerciantes. Puedes elegir compartir\n" +
"información con comerciantes o proveedores de comercio electrónico no asociados con\n" +
"Facebook a través de ofertas en el sitio web. Esto será a tu entera discreción y no les\n" +
"suministraremos información tuya a dichos comerciantes sin tu consentimiento.\n" +
"Para ayudar a tus amigos a encontrarte. De forma predeterminada, incluimos cierta\n" +
"información que has colocado en tu perfil en los resultados de búsqueda de Facebook para\n" +
"ayudar a tus amigos a encontrarte. Sin embargo, puedes controlar quién puede ver dicha\n" +
"información, así como quién puede encontrarte en búsquedas, a través de la configuración\n" +
"de privacidad. También colaboramos con proveedores de mensajería instantánea y correo\n" +
"electrónico para ayudar a sus usuarios a identificar cuáles de sus contactos son usuarios de\n" +
"Facebook, de forma que podamos promocionar Facebook a dichos usuarios.\n" +
"Para dar a los motores de búsqueda acceso a información públicamente disponible. En\n" +
"general, restringimos el acceso de los motores de búsqueda a nuestro sitio web. Podemos\n" +
"permitirles acceder a información configurada con la opción “todos” (junto con tu nombre\n" +
"y fotografía de perfil) y a la información de tu perfil que sea visible para todos. Puedes\n" +
"cambiar la visibilidad de parte de tu información de perfil usando tu configuración de\n" +
"privacidad. También puedes impedir que los motores de búsqueda sometan a indexado tu\n" +
"perfil usando tu configuración de búsqueda.\n" +
"Para ayudar a mejorar o promocionar nuestro servicio. A veces compartimos datos\n" +
"agregados con terceros para ayudar a mejorar o promocionar nuestro servicio. Sin embargo,\n" +
"sólo lo hacemos de tal manera que no se pueda identificar a ningún usuario en particular ni\n" +
"vincularse a éste con ninguna información o acción específica.\n" +
"Para prestarte servicios. Podemos ofrecer información a proveedores de servicios que nos\n" +
"ayudan a facilitarte los servicios que ofrecemos. Por ejemplo, podemos utilizar a terceros\n" +
"para alojar nuestro sitio web, enviar actualizaciones por correo electrónico acerca de\n" +
"Facebook, eliminar información repetitiva de nuestras listas de usuarios, procesar pagos u\n" +
"ofrecer enlaces o resultados de búsqueda (lo que incluye enlaces promocionados). Estos\n" +
"proveedores de servicios pueden tener acceso a tu información personal para utilizarla\n" +
"durante un período de tiempo limitado, pero cuando esto ocurre, implantamos sistemas de\n" +
"protección técnicos y contractuales razonables para restringir su uso de dicha información a\n" +
"la ayuda que nos prestan para ofrecer el servicio.\n" +
"Para publicitar nuestros servicios. Podemos pedir a anunciantes ajenos a Facebook que\n" +
"muestren anuncios para promocionar nuestros servicios. Podemos pedirles que entreguen\n" +
"dichos anuncios basándose en la presencia de una cookie, pero al hacerlo, no se compartirá\n" +
"ninguna otra información con el anunciante.\n" +
"Para ofrecer servicios conjuntos. Podemos prestar servicios de forma conjunta con otras\n" +
"empresas, como se el caso del servicio de clasificados del Marketplace de Facebook. Si\n" +
"utilizas estos servicios, podemos compartir tu información para facilitar dicho servicio. Sin\n" +
"embargo, identificaremos al socio y te presentaremos la política de privacidad del \n" +
"proveedor de servicios conjuntos antes de que utilices dicho servicio.\n" +
"Para responder a requerimientos legales y evitar daños. Podemos revelar información\n" +
"con arreglo a citaciones, órdenes judiciales u otros requerimientos (incluidos asuntos civiles\n" +
"y penales) si creemos de buena fe que la ley exige dicha respuesta. Esto puede incluir\n" +
"respetar requerimientos de jurisdicciones ajenas a los Estados Unidos cuando creamos de\n" +
"buena fe que las leyes locales de tal jurisdicción exigen dicha respuesta, son aplicables a\n" +
"usuarios de dichas jurisdicción y resultan coherentes con estándares internacionales\n" +
"generalmente aceptados. También podemos compartir información si creemos de buena fe\n" +
"que resulta necesario para impedir un fraude u otra actividad ilegal, evitar un daño físico\n" +
"inminente o protegernos tanto a nosotros como al usuario de personas que infrinjan nuestra\n" +
"Declaración de derechos y responsabilidades. Esto puede incluir compartir información con\n" +
"otras empresas, abogados, tribunales u otras entidades gubernamentales.\n" +
"Transferencia en caso de venta o cambio de control. Si la propiedad de toda o\n" +
"prácticamente toda nuestra empresa cambia, podemos transferir tu información al nuevo\n" +
"propietario para que el servicio pueda seguir operativo. En tal caso, tu información seguiría\n" +
"estando sujeta a los compromisos asumidos en la Política de privacidad preexistente.\n" +
"7. Cómo puedes cambiar o eliminar información\n" +
"Edición de tu perfil. Puedes cambiar o eliminar la información de tu perfil en cualquier\n" +
"momento yendo a la página de tu perfil y haciendo clic en “Editar mi perfil”. La\n" +
"información se actualizará de inmediato.\n" +
"Eliminar los contactos cargados. Si utilizas nuestra herramienta para importar contactos\n" +
"con el fin de cargar direcciones, después puedes eliminar la lista en esta página de ayuda.\n" +
"Puedes eliminar las direcciones de correo electrónico de amigos que hayas invitado a unirse\n" +
"a Facebook en tu página del historial de invitaciones.\n" +
"Desactivación o eliminación de la cuenta. Si quieres dejar de utilizar tu cuenta, puedes\n" +
"desactivarla o eliminarla. Cuando desactivas una cuenta, ningún usuario podrá verla, pero\n" +
"no será eliminada. Guardamos la información de tu perfil (conexiones, fotos, etc.) por si\n" +
"más tarde decides volver a activarla. Muchos usuarios desactivan sus cuentas por motivos\n" +
"temporales y al hacerlo, nos piden que mantengamos su información hasta que vuelvan a\n" +
"Facebook. Seguirás pudiendo reactivar la cuenta y restaurar tu perfil en su totalidad.\n" +
"Cuando eliminas una cuenta, se borra de forma permanente de Facebook. Sólo deberías\n" +
"eliminar tu cuenta si estás seguro de que nunca querrás reactivarla. Puedes desactivar la\n" +
"cuenta en la página de configuración de la cuenta o eliminar tu cuenta en esta página de\n" +
"ayuda.\n" +
"Limitaciones sobre la eliminación. Incluso después de eliminar información de tu perfil o\n" +
"eliminar tu cuenta, pueden permanecer copias de dicha información visible en otro lugar en\n" +
"la medida en que se haya compartido con otros, se haya distribuido de otro modo conforme\n" +
"a tu configuración de privacidad, o haya sido copiada o almacenada por otros usuarios. Sin\n" +
"embargo, tu nombre dejará de estar asociado con dicha información en Facebook. (Por\n" +
"ejemplo, si publicas algo en el perfil de otro usuario y después eliminas tu cuenta, dicha\n" +
"publicación podría permanecer, pero atribuirse a un “Usuario de Facebook anónimo”.)\n" +
"Asimismo, podemos conservar cierta información para evitar el robo de identidades y otras\n" +
"conductas inadecuadas, incluso si se ha solicitado la eliminación. Si has facilitado a\n" +
"aplicaciones o sitios web de terceros acceso a tu información, éstos pueden conservar tu\n" +
"información hasta el límite permitido por sus términos de servicio o políticas de privacidad.\n" +
"Sin embargo, después de desconectarte de ellos, ya no podrán acceder a la información a\n" +
"través de nuestra plataforma.\n" +
"Copias de seguridad. La información eliminada y borrada puede permanecer en copias de\n" +
"seguridad hasta un máximo de 90 días, pero no estará disponible para los demás.\n" +
"Información de contacto de no usuarios. Si un usuario nos facilita tu dirección de correo\n" +
"electrónico pero no eres usuario de Facebook y quieres que la eliminemos, puedes hacerlo \n" +
"en esta página de ayuda. Sin embargo, esa solicitud sólo se aplicará a las direcciones que\n" +
"tengamos en el momento de la solicitud y no a ninguna dirección que los usuarios nos\n" +
"faciliten posteriormente.\n" +
"8. Cómo protegemos la información\n" +
"Hacemos todo lo posible para mantener a salvo tu información, pero necesitamos tu ayuda.\n" +
"Para obtener información más pormenorizada sobre cómo mantener la seguridad en\n" +
"Facebook, visita la página de seguridad (Facebook Security) de Facebook.\n" +
"Medidas que tomamos para mantener a salvo tu información. Mantenemos la información\n" +
"de tu cuenta en un servidor protegido con un firewall. Cuando introduces información\n" +
"confidencial (por ejemplo, contraseñas y números de tarjeta de crédito), la ciframos\n" +
"usando tecnología de capa de socket seguro (SSL). También utilizamos medidas sociales y\n" +
"automatizadas para aumentar la seguridad (como el análisis de la actividad de la cuenta\n" +
"por si hubiera algún comportamiento fraudulento o anómalo de otro tipo), podemos limitar\n" +
"el uso de funciones del sitio web en respuesta a posibles signos de abuso, podemos eliminar\n" +
"contenido inadecuado o enlaces a contenido ilegal, y podemos suspender o desactivar\n" +
"cuentas por si hubiera violaciones de nuestra Declaración de derechos y responsabilidades.\n" +
"Riesgos inherentes a compartir información. Aunque te permitimos definir opciones de\n" +
"privacidad que limiten el acceso a tu información, ten en cuenta que ninguna medida de\n" +
"seguridad es perfecta ni impenetrable. No podemos controlar las acciones de otros usuarios\n" +
"con los que compartas información. No podemos garantizar que sólo vean tu información\n" +
"personas autorizadas. No podemos garantizar que la información que compartas en\n" +
"Facebook no pase a estar disponible públicamente. No somos responsables de que ningún\n" +
"tercero burle cualquier configuración de privacidad o medidas de seguridad en Facebook.\n" +
"Puedes reducir estos riesgos utilizando hábitos de seguridad de sentido común como elegir\n" +
"una contraseña segura, utilizar contraseñas diferentes para servicios diferentes y emplear\n" +
"software antivirus actualizado.\n" +
"Informar de incumplimientos. Deberías informarnos de cualquier incumplimiento de la\n" +
"seguridad en esta página de ayuda.\n" +
"9. Otros términos\n" +
"Cambios. Podemos cambiar esta Política de privacidad conforme a los procedimientos\n" +
"señalados en la Declaración de derechos y responsabilidades de Facebook. Salvo indicación\n" +
"en contrario, nuestra política de privacidad en vigor se aplica a toda la información que\n" +
"tenemos sobre ti y tu cuenta. Si realizamos cambios en esta Política de privacidad, te lo\n" +
"notificaremos publicándolo aquí y en la página Facebook Site Governance. Puedes\n" +
"asegurarte de que recibes notificación directamente haciéndote fan de la página Facebook\n" +
"Site Governance.\n" +
"Consentimiento para la recopilación y procesamiento en\n" +
"Estados Unidos. Al utilizar Facebook, das tu consentimiento\n" +
"para que tus datos personales sean transferidos y procesados\n" +
"en Estados Unidos.\n" +
"Términos definidos. \"Nos\", \"nosotros\", \"nuestro\", \"Plataforma\" y \"Facebook\" significan lo\n" +
"mismo que en la Declaración de derechos y responsabilidades. “Información” y “contenido”\n" +
"se utilizan de forma más general e intercambiable aquí que en la Declaración de derechos y\n" +
"responsabilidades, salvo que el contexto lo limite de otro modo.</font><hr/>"; 
html+="</body></html>"; 
JEditorPane ed1=new JEditorPane("text/html",html); 
add(ed1); 
setVisible(true); setSize(600,600); 
setDefaultCloseOperation(EXIT_ON_CLOSE); } 
catch(Exception e) { e.printStackTrace(); System.out.println("Some problem has occured"+e.getMessage()); }
}
} 

