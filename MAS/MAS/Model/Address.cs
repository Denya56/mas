namespace MAS_MP1.Model
{
    [Serializable]
    public class Address
    {
        private string StreetName;
        private string BuildingNumber;
        // Optional attr
        private string? ApartmentNumber;

        public Address(string streetName, string buildingNumber)
        {
            SetStreetName(streetName);
            SetBuildingNumber(buildingNumber);
        }

        public Address(string streetName, string buildingNumber, string? apartmentNumber)
        {
            SetStreetName(streetName);
            SetBuildingNumber(buildingNumber);
            SetAppartmentNumber(apartmentNumber);
        }

        #region GETTERS
        public string GetStreetName()
        {
            return StreetName;
        }
        public string GetBuildingNumber()
        {
            return BuildingNumber;
        }
        public string GetAppartmentNumber()
        {
            return ApartmentNumber;
        }
        #endregion

        #region SETTERS
        private void SetStreetName(string name)
        {
            if(!string.IsNullOrEmpty(name))
            {
                StreetName = name;
            }
        }
        private void SetBuildingNumber(string numb)
        {
            if (!string.IsNullOrEmpty(numb))
            {
                BuildingNumber = numb;
            }
        }
        private void SetAppartmentNumber(string? numb)
        {
            if (numb == "")
            {
                throw new ArgumentException();
            }
            else
                ApartmentNumber = numb;
        }
        #endregion

        public override string ToString()
        {
            return $"{StreetName} {BuildingNumber} {ApartmentNumber}";
        }
    }
}
