import java.util.*;
class Columnar {

static String key;
static String plain_text;
static StringBuilder cipher_text;
static char[][] final_array;
static int[] indices;
static StringBuilder obtained_plain_text;
public static void encrypt(){

StringBuilder strkey = new StringBuilder(key);
indices = new int[key.length()];
plain_text = plain_text.replaceAll("\\s+", "");
char[] arr = key.toCharArray();
Arrays.sort(arr);
for(int i=0; i<arr.length; i++){
char current = arr[i];
for(int j=0; j<strkey.length(); j++){
if(strkey.charAt(j) ==

current){

indices[j] =

(i+1);
strkey.replace(j, j+1, "$");

break;

}

}

}
int mod = 0;
if(plain_text.length() % key.length() != 0)

mod = plain_text.length() % key.length();

int add_x = key.length() - mod;
if(add_x != 6){

StringBuilder str = new

StringBuilder(plain_text);

while(add_x-- != 0)

str.append("X");
plain_text = str.toString();

}
int rows = plain_text.length()/key.length();
final_array = new char[rows+2][key.length()];
for(int i=0; i<key.length(); i++)

final_array[0][i] = key.charAt(i);

for(int i=0; i<key.length(); i++)
final_array[1][i] =

Character.forDigit(indices[i], 10);
int count=0;
for(int i=2; i<(rows+2); i++){

for(int j=0; j<key.length(); j++)
final_array[i][j] =

plain_text.charAt(count++);
}
//print the matrix
System.out.println("----------MATRIX-----------");
for(int i=0; i<rows+2 ;i++){
System.out.println(Arrays.toString(final_array[i]));

}
cipher_text = new StringBuilder();
String sequence = String.valueOf(final_array[1]);
for(int i=1; i<=key.length(); i++){

int index =

sequence.indexOf(Character.forDigit(i, 10));

for(int j=2; j<(rows+2); j++)

cipher_text.append(final_array[j][index]);

}
System.out.println("Cipher Text: " + cipher_text);

}
public static void decrypt(){

int count = (cipher_text.length()/key.length());
char[][] to_find_pt = new char[count+2][key.length()];
for(int i=0; i<key.length(); i++)

to_find_pt[0][i] = key.charAt(i);

for(int i=0; i<key.length(); i++)
to_find_pt[1][i] =

Character.forDigit(indices[i], 10);
int count1 = 0;
String sequence = String.valueOf(to_find_pt[1]);
for(int i=1; i<=key.length(); i++){

int index =

sequence.indexOf(Character.forDigit(i, 10));

for(int j=2; j<count+2; j++){
to_find_pt[j][index] =

cipher_text.charAt(count1++);

}

}
obtained_plain_text = new StringBuilder();
for(int j=2; j<count+2; j++){

for(int i=0; i<key.length();

i++)
obtained_plain_text.append(to_find_pt[j][i]);

}
System.out.println("---------------------");
System.out.println("Decrypted plain text: " +

obtained_plain_text);
}
public static void main(String args[]){

Scanner sc = new Scanner(System.in);
key = sc.nextLine();
plain_text = sc.nextLine();
encrypt();
decrypt();
System.out.println("60004160006");

}

}