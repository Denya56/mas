namespace MAS_MP1.Model
{
    [Serializable]
    public class Pub : ObjectPlus
    {
        // Mandatory attr
        private string Name;
        private string Description;
        // Multi-value attr
        public Dictionary<Beer, int> BeerSold = new Dictionary<Beer, int>();
        // Class attr
        public static Dictionary<Beer, int> BeerLeft = new Dictionary<Beer, int>();
        // Complex attr
        private Address PubAddress;
        private string PhoneNumber;
        private int Budget;


        public Pub(string name, string description, Address address, string phoneNumber, int budget) : base()
        {
            try
            {
                SetName(name);
                SetDescription(description);
                SetPubAddress(address);
                SetPhoneNumber(phoneNumber);
                SetBudget(budget);
            }
            catch (Exception)
            {
                RemoveThisFromExtent();
            }
        }

        #region GETTERS
        public string GetName()
        {
            return Name;
        }

        public string GetDescription()
        {
            return Description;
        }

        public Address GetPubAdress()
        {
            return PubAddress;
        }

        public string GetPhoneNumber()
        {
            return PhoneNumber;
        }
        public int GetBudget()
        {
            return Budget;
        }

        public Dictionary<Beer, int> GetBeerSold()
        {
            return new Dictionary<Beer, int>(BeerSold);
        }

        public Dictionary<Beer, int> GetbeerLeft()
        {
            return new Dictionary<Beer, int>(BeerLeft);
        }

        public int GetBeerOfKindSold(Beer beer)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if (BeerSold.Where(x => x.Key.Equals(beer)).Count() == 0)
            {
                throw new ArgumentException("This beer is not in the list");
            }
            else
                return BeerSold
                   .Where(x => x.Key.Equals(beer))
                   .Select(x => x.Value)
                   .First();
        }

        public static int BeerOfKindLeft(Beer beer)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if (BeerLeft.Where(x => x.Key.Equals(beer)).Count() == 0)
            {
                throw new ArgumentException("This beer is not in the list");
            }
            else
                return BeerLeft
                   .Where(x => x.Key.Equals(beer))
                   .Select(x => x.Value)
                   .First();
        }

        // Derived attr
        public int getIncome()
        {
            return BeerSold
                .Select(x => x.Key.Price * x.Value)
                .Sum();
        }
        #endregion

        #region SETTERS
        private void SetName(string name)
        {
            if (string.IsNullOrEmpty(name))
            {
                throw new ArgumentException("Name shold be specified");
            }
            else
                Name = name;
        }

        private void SetDescription(string desc)
        {
            if (string.IsNullOrEmpty(desc))
            {
                throw new ArgumentException("Description shold be specified");
            }
            else
                Description = desc;
        }

        private void SetPhoneNumber(string number)
        {
            if (string.IsNullOrEmpty(number))
            {
                throw new ArgumentException("Phone number shold be specified");
            }
            else if(number.Length > 12)
            {
                throw new ArgumentOutOfRangeException("Phone number must not contain more than 12 chracters");
            }
            else
                PhoneNumber = number;
        }

        private void SetPubAddress(Address address)
        {
            if (address == null)
            {
                throw new ArgumentNullException("Address shold be specified");
            }
            else 
                PubAddress = address;
        }
        private void SetBudget(int budget)
        {
            if(budget <= 0)
            {
                throw new ArgumentOutOfRangeException("Budget cannot be smaller than 0");
            }
            else
                Budget = budget;
        }

        public void AddBeerSold(Beer beer, int amount)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if(amount < 0)
            {
                throw new ArgumentOutOfRangeException();
            }
            else
            {
                BeerSold.Add(beer, amount);
            }
        }

        public void AddBeerLeft(Beer beer, int amount)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if (amount < 0)
            {
                throw new ArgumentOutOfRangeException();
            }
            else
            {
                BeerLeft.Add(beer, amount);
            }
        }
        #endregion

        public void ChangeBeerSoldAmount(Beer beer, int amount)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if(BeerSold.Where(x =>x.Key.Equals(beer)).Count() == 0)
            {
                throw new ArgumentException("This beer is not in the list");
            }
            else
            {
                BeerSold
                    .Where(x => x.Key.Equals(beer))
                    .Select(x => x.Value + amount);
            }
        }

        public void ChangeBeerLeftAmount(Beer beer, int amount)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else if (BeerLeft.Where(x => x.Key.Equals(beer)).Count() == 0)
            {
                throw new ArgumentException("This beer is not in the list");
            }
            else
            {
                BeerLeft
                    .Where(x => x.Key.Equals(beer))
                    .Select(x => x.Value + amount);
            }
        }

        public void RemoveBeerSold(Beer beer)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else
            {
                if (BeerSold.Remove(beer))
                    Console.WriteLine($"Removed {beer} from the sold list" );
                else
                    Console.WriteLine("No such beer in the list");
            }
        }

        public void RemoveBeerLeft(Beer beer)
        {
            if (beer == null)
            {
                throw new ArgumentNullException();
            }
            else
            {
                if (BeerLeft.Remove(beer))
                    Console.WriteLine($"Removed {beer} from the sold list");
                else
                    Console.WriteLine("No such beer in the list");
            }
        }

        private void RemoveThisFromExtent()
        {
            AllExtents.Remove(GetType());
        }

        public override string ToString()
        {
            return $"{Name} {PubAddress} {PhoneNumber}";
        }
    }
}
