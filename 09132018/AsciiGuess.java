import java.util.Scanner;

public class AsciiGuess {
    public static void main(String[] args) {
        String[] ascii = {
                "#############################################################",
                "###################################################   #######",
                "###############################################   /~\\   #####",
                "############################################   _- `~~~', ####",
                "##########################################  _-~       )  ####",
                "#######################################  _-~          |  ####",
                "####################################  _-~            ;  #####",
                "##########################  __---___-~              |   #####",
                "#######################   _~   ,,                  ;  `,,  ##",
                "#####################  _-~    ;'                  |  ,'  ; ##",
                "###################  _~      '                    `~'   ; ###",
                "############   __---;                                 ,' ####",
                "########   __~~  ___                                ,' ######",
                "#####  _-~~   -~~ _                               ,' ########",
                "##### `-_         _                              ; ##########",
                "#######  ~~----~~~   ;                          ; ###########",
                "#########  /          ;                        ; ############",
                "#######  /             ;                      ; #############",
                "#####  /                `                    ; ##############",
                "###  /                                      ; ###############"
        };

        for(String element : ascii) {
            System.out.println(element);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nSo... What animal is that? ");
        String respuesta = sc.nextLine();

        if(respuesta.toLowerCase().equals("Wolf".toLowerCase())) {
            System.out.println("Yea! You got it right!");
        } else {
            System.out.println("Nah. That was a wolf.");
        }
    }
}