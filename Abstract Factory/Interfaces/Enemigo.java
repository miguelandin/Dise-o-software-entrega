package Interfaces;

import Jugador.Jugador;

// La interfaz Enemigo define las características y comportamientos que deben tener todos los enemigos en el juego
public interface Enemigo {
    // Método para obtener el nombre del enemigo
    String getNombre();
    
    // Método para obtener los puntos de vida del enemigo
    int getVida();
    
    // Método para obtener el daño que puede infligir el enemigo
    int getDanio();
    
    // Método para obtener la habilidad mágica del enemigo
    int getMagia();
    
    // Método para obtener la velocidad del enemigo
    int getVelocidad();
    
    // Método para obtener el estado que puede aplicar el enemigo al jugador
    EstadoJugador estadoAplicable();
    
    // Método para obtener la estrategia específica del enemigo (si la tiene)
    Murcielago_Estrategia estrategia();
    
    // Método para que el enemigo reciba un ataque del jugador
    void recibirAtaque(int danio);
    
    // Método para obtener los puntos otorgados al jugador al derrotar este enemigo
    int getPuntos();
    


    

    /*
     
     -boss final
                        ==(W{==========-      /===-                        
                              ||  (.--.)         /===-_---~~~~~~~~~------____  
                              | \_,|**|,__      |===-~___                _,-' `
                 -==\\        `\ ' `--'   ),    `//~\\   ~~~~`---.___.-~~      
             ______-==|        /`\_. .__/\ \    | |  \\           _-~`         
       __--~~~  ,-/-==\\      (   | .  |~~~~|   | |   `\        ,'             
    _-~       /'    |  \\     )__/==0==-\<>/   / /      \      /               
  .'        /       |   \\      /~\___/~~\/  /' /        \   /'                
 /  ____  /         |    \`\.__/-~~   \  |_/'  /          \/'                  
/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`                   
                  \_|      /        _) | ;  ),   __--~~                        
                    '~~--_/      _-~/- |/ \   '-~ \                            
                   {\__--_/}    / \\_>-|)<__\      \                           
                   /'   (_/  _-~  | |__>--<__|      |                          
                  |   _/) )-~     | |__>--<__|      |                          
                  / /~ ,_/       / /__>---<__/      |                          
                 o-o _//        /-~_>---<__-~      /                           
                 (^(~          /~_>---<__-      _-~                            
                ,/|           /__>--<__/     _-~                               
             ,//('(          |__>--<__|     /                  .----_          
            ( ( '))          |__>--<__|    |                 /' _---_~\        
         `-)) )) (           |__>--<__|    |               /'  /     ~\`\      
        ,/,'//( (             \__>--<__\    \            /'  //        ||      
      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'       
    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/                  
  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~                    
   ;'( ')/ ,)(                              ~~~~~~~~~~                         
  ' ') '( (/                                                                   
    '   '  `




                        ==(W{==========-      /===-                        
                              ||  (.--.)         /===-_---~~~~~~~~~------____  
                              | \_,|**|,__      |===-~___                _,-' `
                 -==\\        `\ ' `--'   ),    `//~\\   ~~~~`---.___.-~~      
             ______-==|        /`\_. .__/\ \    | |  \\           _-~`         
       __--~~~  ,-/-==\\      (   | .  |~~~~|   | |   `\        ,'             
    _-~       /'    |  \\     )__/==0==-\<>/   / /      \      /               
  .'        /       |   \\      /~\___/~~\/  /' /        \   /'                
 /  ____  /         |    \`\.__/-~~   \  |_/'  /          \/'                  
/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`                   
                  \_|      /        _) | ;  ),   __--~~                        
                    '~~--_/      _-~/- |/ \   '-~ \                            
                   {\__--_/}    / \\_>-|)<__\      \                           
                   /'   (_/  _-~  | |__>--<__|      |                          
                  |   _/) )-~     | |__>--<__|      |                          
                  / /~ ,_/       / /__>---<__/      |                          
                 o-o _//        /-~_>---<__-~      /                           
                 (_(/          /~_>---<__-      _-~                            
                              /__>--<__/     _-~                               
                             |__>--<__|     /                  .----_          
                             |__>--<__|    |                 /' _---_~\        
                             |__>--<__|    |               /'  /     ~\`\      
                              \__>--<__\    \            /'  //        ||      
                                ~-__>--<_~-_  ~--____---~' _/'/        /'       
                                  ~-_~>--<_/-__       __-~ _/                  
                                    ~~-'_/_/ /~~~~~~~__--~                    
                                          ~~~~~~~~~~                         
                                                                  
      
      
     * */

}
