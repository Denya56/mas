// See https://aka.ms/new-console-template for more information
using MAS_MP1.Model;

Console.WriteLine("Hello, World!");

Pub p = new Pub("Name", "d", new Address("street", "34"), "1232131", 100);

//Console.WriteLine(p.GetBeerOfKindSold(new Beer("name", 1)));


foreach (var item in ObjectPlus.GetExtents(p.GetType().Name))
{
    var i = (Pub)item;
    Console.WriteLine(i);
}

ObjectPlus.WriteExtent();
