using System.Data;
using Newtonsoft.Json;

namespace MAS_MP1.Model
{
    public class ObjectPlus
    {
        public static Dictionary<Type, List<object>> AllExtents = new Dictionary<Type, List<object>>();
        private static string FILENAME = "extent.xml";
        public ObjectPlus()
        {
            //Console.WriteLine(GetType());
            List<object> extent = AllExtents.SelectMany(x => x.Value)
                    .Where(x => x.GetType() == GetType())
                    .ToList();

            if (extent.Count == 0)
            {
                extent = new List<object>();
                AllExtents.Add(GetType(), extent);
            }
            extent.Add(this);
            /*foreach (var item in AllExtents)
            {
                Console.WriteLine($"{item.Key} {item.Value}");
            }*/
        }

        public static void WriteExtent()
        {
            
            string jsonString = JsonConvert.SerializeObject(AllExtents);
            try
            {
                File.WriteAllText(FILENAME, jsonString);
            }
            catch (Exception)
            {
                throw;
            }

            //Console.WriteLine(File.ReadAllText(fileName));
        }

        public static void LoadExtent()
        {
            string? s;
            Dictionary<Type, List<object>>? temp;
            try
            {
                s = File.ReadAllText(FILENAME);
            }
            catch (Exception)
            {
                throw;
            }
            if (s == null)
            {
                throw new NullReferenceException();
            }
            if ((temp = (Dictionary<Type, List<object>>?) JsonConvert.DeserializeObject(s)) == null)
            {
                throw new NullReferenceException();
            }
            else
                AllExtents = temp;
        }

        public static List<object> GetExtents(string name)
        {
            List<object> l = AllExtents.SelectMany(x => x.Value)
                    .Where(x => x.GetType().Name == name)
                    .ToList();

            if(l.Count == 0) 
                return new List<object>();
            else
                return l;
        }
    }
}
