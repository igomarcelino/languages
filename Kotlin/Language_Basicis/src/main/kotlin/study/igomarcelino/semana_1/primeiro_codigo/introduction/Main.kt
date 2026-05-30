package study.igomarcelino

fun main() {
    println("What's your name?");
    var name = readln();
    println("Hello " + name); // Concatenando String
    println("Hello $name"); // utilizando a string dentro da string
    var pessoa: String = "Igo marcelino";
    println(pessoa.javaClass.name);
}