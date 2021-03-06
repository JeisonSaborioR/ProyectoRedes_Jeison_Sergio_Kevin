#include <SparkFunHTU21D.h>

/* //////////////////////////////////////////
  Humidity instance
* //////////////////////////////////////////*/
HTU21D humiditySensor; 
float humidity;

void setup()
{
  Serial.begin(9600);  // Start serial for output

  /* //////////////////////////////////////////
      Humidity Setup
  * //////////////////////////////////////////*/
  humiditySensor.begin();
  
}

void loop()
{

  /* //////////////////////////////////////////
      Humidity
  * //////////////////////////////////////////*/
  humidity = humiditySensor.readHumidity();
  Serial.println(humidity);

  ////////////////////////////////////////////  
  Serial.println("------------------------\n");
  delay(5000);  
}
