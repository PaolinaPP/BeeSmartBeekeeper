#include <SoftwareSerial.h>
// izhod RX , TX  GPRS module
SoftwareSerial gprs(2, 3);

#include <String.h>
#include <DHT11.h>

DHT11 dht11(A1);
int err;
float hum ;
float temp ;

int ID = 2 ;
#define soundPin A0
byte Open = 1;
int sound ;

void setup() {
  Serial.begin(9600);
  gprs.begin(9600);
  delay(1);



}

void loop() {
  // Read data 
  err = dht11.read(hum, temp);
  sound = analogRead(soundPin);
  
  // connect to GPRS and send
  gprs.println("AT");
  delay(1000);

  gprs.println("AT+SAPBR = 2,1");
  delay(1000);

  gprs.println("AT+SAPBR = 1,1");
  delay(1000);

  gprs.println("AT+HTTPINIT ");
  delay(1000);

  /*
  gprs.print("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/proba.php?proba=");
  gprs.print(chislo);
  gprs.println("\"");
  delay(2000);
  chislo += 100;
  */
  gprs.print("AT+HTTPPARA=\"URL\",\"http://api.thingspeak.com/update?api_key=0QV55S54U716K8JH&field1=");
  gprs.print(temp);
  gprs.print("&field2=");
  gprs.print(hum);
  gprs.print("&field3=");
  gprs.print(sound);
  gprs.print("&field4=");
  gprs.print(Open);
  gprs.println("\"");
  delay(2000);
  /*
  gprs.print("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=");
  gprs.print(ID);
  gprs.print("&temp=");
  gprs.print(temp);
  gprs.print("&hum=");
  gprs.print(hum);
  gprs.print("&s=");
  gprs.print(sound);
  gprs.print("&o=");
  gprs.print(Open);
  gprs.println("&submitBtn=Vavedi\"");
  delay(2000);
  */
  gprs.println("AT+HTTPPARA=\"CID\",1");
  delay(1000);

  gprs.println("AT+HTTPACTION=0");
  delay(1000);

  gprs.println("AT+HTTPREAD");
  delay(1000);
  ShowSerialData();
  delay(1000);

  gprs.println("AT+HTTPTERM");
  delay(10000);

}

void ShowSerialData()
{
  while (gprs.available() != 0)
    Serial.write(gprs.read());
}



/*
  http.toCharArray(charbuffer, 100);
  gprs.println("AT+HTTPPARA=\"URL\",\http://api.thingspeak.com/update?api_key=0QV55S54U716K8JH&field1=0\"");
  //gprs.println("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=10&temp=15&hum=30.1&s=1&o=1&submitBtn=Vavedi\"");
  gprs.println("AT+HTTPPARA=\"URL\",\"api.thingspeak.com/update?api_key=KV4S9AH2EUR6YHMO&"+ stoinost +" \"");
  //gprs.println("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=10&temp=15&hum=30.1&s=1&o=1&submitBtn=Vavedi\"");
  //Serial.println("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=10&temp=15&hum=30.1&s=1&o=1&submitBtn=Vavedi\"");
  delay(2000);
  ShowSerialData();
  gprs.write(AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=10&temp=15&hum=30.1&s=1&o=1&submitBtn=Vavedi\"");
  //gprs.println("AT+HTTPPARA=\"URL\",\"http://rado-99.000webhostapp.com/?h_id=10&temp=15&hum=30.1&s=1&o=1&submitBtn=Vavedi\"");
*/

