package game;

public enum Valor {
    AS("Ás", 11),
    DOIS("Dois", 2),
    TRES("Três", 3),
    QUATRO("Quatro",4),
    CINCO("Cinco",5),
    SEIS("Seis",6),
    SETE("Sete",7),
    OITO("Oito",8),
    NOVE("Nove",9),
    DEZ("Dez",10),
    VALETE("Valete",10),
    DAMA("Dama",10),
    REI("Rei",10);

    String name;
    int rankValue;

    Valor(String name, int rankValue){
        this.name = name;
        this.rankValue = rankValue;
    }

    public String getName(){
        return name;
    }
}
