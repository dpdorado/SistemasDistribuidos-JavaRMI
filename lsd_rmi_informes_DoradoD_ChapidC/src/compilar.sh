echo "Compilando archivos fuente..."
javac -d ../bin sop_rmi/interfaces/*.java

javac -d ../bin sop_rmi/implementacion/*.java

javac -d ../bin sop_rmi/callback/*.java

javac -d ../bin servidor/dao/*.java

javac -d ../bin servidor/dto/*.java

javac -d ../bin servidor/utilidades/persistencia/*.java

javac -d ../bin servidor/utilidades/servidor/*.java

javac -d ../bin cliente/gui/*.java

javac -d ../bin cliente/objetosremotos/*.java

javac -d ../bin cliente/utilidades/*.java

javac -d ../bin cliente/*.java

echo "Archivos Compilados!"
