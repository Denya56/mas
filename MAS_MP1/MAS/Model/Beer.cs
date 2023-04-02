namespace MAS_MP1.Model
{
    [Serializable]
    public class Beer : ObjectPlus
    {
        public string Name { get; set; }
        public int Price { get; set; }

        public Beer(string name, int price)
        {
            Name = name;
            Price = price;
        }
    }
}
