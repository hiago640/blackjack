package game;

public enum Naipe {
    PAUS("Paus"),
    OUROS("Ouros"),
    COPAS("Copas"),
    ESPADAS("Espadas");

    String name;

    Naipe(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
