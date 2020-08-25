using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UVnaloga
{
    public partial class info : Form
    {
        String loc;

        public info(String skupaj, String lokacija)
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

            loc = lokacija;
            String[] deljeno = skupaj.Split(new[] { "-" }, StringSplitOptions.None);

            Dictionary<string, string> mere = new Dictionary<string, string>();
            mere.Add("Celzij", "Celzijeva temperaturna lestvica je lestvica za merjenje temperatur, ki jo je leta 1742 predlagal švedski astronom Anders Celsius. Stopinjo v tej lestvici navadno označujemo z oznako °C. V Celzijevi lestvici ustreza 0 °C tališču ledu, 100 °C pa vrelišču vode.");
            mere.Add("Fahrenheit", "Fahrenheitova temperatúrna lestvica je lestvica za merjenje temperatur, ki jo je leta 1724 predlagal nemški fizik Daniel Gabriel Fahrenheit. Stopinjo Fahrenheita se označuje z oznako °F. Za ničlo svoje lestvice je Fahrenheit vzel najnižjo temperaturo, ki jo je lahko ponovljivo dosegel z mešanico ledu in soli, kot drugo umeritveno točko pa je vzel temperaturo človeškega telesa.Interval med njima je sprva razdelil na 12 enot, pozneje pa vsako od njih na dodatnih 8 enot, torej skupno 96 stopinj.V tej temperaturni lestvici voda zmrzuje pri normalnem zračnem tlaku pri 32 °F in vre pri 212 °");
            mere.Add("Kelvin", "Kelvinova temperaturna lestvica (tudi absolutna temperaturna lestvica) je lestvica za merjenje temperatur, ki jo je leta 1848 predlagal škotski inženir in fizik William Thomson, kasneje povzdignjen v lorda Kelvina. Absolutna temperaturna lestvica ne pozna negativnih vrednosti - ničla v tej lestvici sovpada z absolutno ničlo.Lestvica je razdeljena na enote, imenovane kelvin(oznaka K).En kelvin je določen kot 1 / 273, 16 razlike med temperaturo trojne točke vode in absolutno ničlo.Po velikosti intervala kelvin tako sovpada s stopinjo celzija, kar olajša pretvorbo.");

            mere.Add("Liter", "Liter (oznaka l ali L) je metrična enota za merjenje prostornine, enaka enemu kubičnemu decimetru oziroma tisočini kubičnega metra, kar ustreza kocki s stranicami dolžine enega decimetra. Ni del mednarodnega sistema enot (SI) – izpeljana enota SI za prostornino je kubični meter, je pa po dogovoru Mednarodnega urada za uteži in mere zaradi razširjenosti v vsakdanjem življenju liter sprejemljiv za uporabo s sistemom SI.");
            mere.Add("Deciliter", "Deciliter (oznaka dl ali dL) je metrična enota za merjenje prostornine, enaka enemu 0.1 litru.");
            mere.Add("Kubični meter", "Kubični meter (oznaka m³) je izpeljana enota mednarodnega sistema enot za prostornino. En kubični meter je prostornina kocke z robom en meter. En kubični meter ustreza 1000 litrom.");
            mere.Add("Kubični centimeter", "Kubični centimeter (oznaka cm³) je prostorninska fizikalna enota, ki ustreza prostornini kocke s stranico 1 cm. Eden kubični meter je 1000000 kubičnih centimetrov.");

            mere.Add("Galon", "Galona ali galon je imperialna prostorninska mera za prostornino. Eden galon je 3,785 litra.");
            mere.Add("Unča", "Unča je imperialna enota za maso, enaka 28,35 g. Definirana je v okviru avoirdupois masnega sistema, po katerem je 1 avoirdupois funt enak 16 avoirdupois unčam. Ime avoirdupois izhaja iz francoskega izraza »aveir de peis« in pomeni »blago po teži«, nanašajoč se na blago, ki je bilo prodano glede na njegovo težo (in ne npr. količino).");
            mere.Add("Kvart", "Kvart je imperialna enota za merjenje prostornine. Eden kvart predstavlja približno četrtino galona. Čeprav se je velikost enega kvarta čez zgodovino spreminjala pa je sedaj približno 1 liter.");

            mere.Add("Kvadratni metri", "Kvadratni meter(oznaka m²) je izpeljana enota mednarodnega sistema enot za površino.En kvadratni meter je ploščina kvadrata z robom en meter.");
            mere.Add("Hektari", "Hektar (oznaka ha) je enota za površino, enaka stotim (predpona hekto- pomeni stokrat večjo enoto) arom. Površina enega hektara ustreza ploščini kvadrata s stranico 100 m. En hektar je enak 10.000 m² ali 0,01 km². Zaradi svoje primerne velikosti je posebej v rabi v kmetijstvu.");
            mere.Add("Kvadratni kilometri", "Kvadratni kilometer (oznaka km²) je izpeljana enota mednarodnega sistema enot za površino. En kvadratni kilometer je ploščina kvadrata z robom en kilometermeter.");
            mere.Add("Kvadratni centimetri", "Kvadratni centimeter (oznaka cm²) je izpeljana enota mednarodnega sistema enot za površino. En kvadratni centimeter je ploščina kvadrata z robom en centimeter.");

            mere.Add("Aker", "Aker je površinska mera, ki jo uporabljajo v Združenem kraljestvu, nekaterih državah Commonwealtha in v ZDA. Aker je enak 40.468 arov, 0.40468 ha, 4046.8 kvadratnih metrov ali 0.0040468 kvadratnih kilometrov.");
            mere.Add("Kvadratna milja", "Kvadratna milija je imperialna enota za merjenje površine. Ena kvadratna milja je ploščina kvadrata z robom en milja.");

            mere.Add("Kilometri", "Kilometer (okrajšava km) je enota za merjenje dolžine, enaka 1000 metrom (predpona »kilo-« v mednarodnem sistemu enot označuje 1000). Enota se običajno uporablja za razdalje med kraji v metrične sistemu, značilni izjemi sta Združeno kraljestvo in ZDA, kjer je v uporabi imperialni sistem.");
            mere.Add("Metri", "Meter (simbol m) je osnovna enota metričnega sistema za merjenje dolžine, enaka razdalji, ki jo svetloba prepotuje v vakuumu v 1⁄299.792.458 sekunde.");
            mere.Add("Centimetri", "Centimeter (označba cm) je enota za merjenje dolžine, enaka eni stotinki metra (predpona »centi-« v mednarodnem sistemu enot označuje 1/100).");
            mere.Add("Milimetri", "Milimeter (označba mm) je enota za merjenje dolžine, enaka eni tisočinki metra (predpona »mili-« v mednarodnem sistemu enot označuje 1/1000).");

            mere.Add("Milja", "Milja (oznaka mi) je ime več enot za merjenje dolžine v imperialnem merkskem sistemu. Danes ena milja v glavnem pomeni okoli 1609 m na kopnem in 1852 m na morju in v zraku.");
            mere.Add("Jard", "Jard (angleško yard) je enota za dolžino. Jard je enak 3 čevljem ali 1/1760 milje, kar je po mednarodnem sistemu 0,9144 metra. Angleško ime za jard izvira iz besede za ravno vejo oziroma palico. Jard (ali polseženj) je enak polovici sežnja, ker izvira iz razdalje med brado in konci prstov na roki (seženj je razdalja med konci prstov ene in druge roke).");
            mere.Add("Cevelj", "Čevelj (angleška označba ft) je enota za dolžino. Izvirno je mera pomenila dolžino človeškega stopala. Enota je enaka 12. palcem (colam) in 1/3 jarda.");
            mere.Add("Palec", "Pálec ali cóla je imperialna mera za dolžino. En palec predstavlja 2.54 cm.");

            Dictionary<string, string> pretvorba = new Dictionary<string, string>();
            pretvorba.Add("Celzij-Celzij", "Pretvarjanje iz celzija v celzij poteka tako, da pomnožimo vrednost v celzijih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12°C * 1 = 12°C");
            pretvorba.Add("Celzij-Kelvin", "Pretvarjanje iz celzija v kelvin poteka tako, da prištejemo vrednosti v celzijih število 273.15. \n \n Primer: 12°C + 273.15 = 285.15K");
            pretvorba.Add("Celzij-Fahrenheit", "Pretvarjanje iz celzija v fahrenheit poteka tako, da vrednost v celzijah pomnožimo z 9/5 ter nato prištejemo še 32. \n \n Primer: (12°C * 9/5) + 32 = 53.6 °F");

            pretvorba.Add("Kelvin-Kelvin", "Pretvarjanje iz kelvina v kelvin poteka tako, da pomnožimo vrednost v kelvinih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12 K * 1 = 12 K");
            pretvorba.Add("Kelvin-Celzij", "Pretvarjanje iz kelvina v celzij poteka tako, da vrednosti v kelvinih odštejemo število 273.15. \n \n Primer: 12K - 273.15 = -261,15°C ");
            pretvorba.Add("Kelvin-Fahrenheit", "Pretvarjanje iz kelvina v fahrenheit poteka tako, da vrednost pretvorimo v celzije(odštejemo 273.15) nato pa še pomnožimo z 9/5 ter prištejemo 32. \n \n Primer: (12K - 273.15) * 9/5 + 32 = -438,07 °F");

            pretvorba.Add("Fahrenheit-Fahrenheit", "Pretvarjanje iz fahrenheita v fahrenheit poteka tako, da pomnožimo vrednost v fahrenheitih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12°F * 1 = 12°F");
            pretvorba.Add("Fahrenheit-Celzij", "Pretvarjanje iz fahrenheita v celzije poteka tako, da vrednosti v fahrenheitih najprej odštejemo število 32 nato pa rezultat še pomnožimo z 5/9. \n \n Primer: (12°F - 32) * 5/9 = -11.11K");
            pretvorba.Add("Fahrenheit-Kelvin", "Pretvarjanje iz fahrenheita v kelvin poteka tako, da vrednost v fahrenheitih najprej pretvorimo v celzije (odštejemo 32 in pomnožimo z 5/9) nato pa še prištejemo 273.15. \n \n Primer: (12°F -32) * 5/9 + 273.15");

            pretvorba.Add("Kubični meter-Kubični meter", "Pretvarjanje iz m³ v m³ poteka tako, da pomnožimo vrednost v kubičnih metrih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12 m³ * 1 = 12 m³");
            pretvorba.Add("Kubični meter-Liter", "Pretvarjanje iz m³ v litre poteka tako, da vrednost v kubičnih metrih pomnožimo z 1000. \n \n Primer: 12 m³ * 1000 = 12000 L");
            pretvorba.Add("Kubični meter-Deciliter", "Pretvarjanje iz m³ v decilitre poteka tako, da vrednost v kubičnih metrih pomnožimo z 10000. \n \n Primer: 12 m³ * 10000 = 120000 L");
            pretvorba.Add("Kubični meter-Kubični centimeter", "Pretvarjanje iz m³ v cm³ poteka tako, da pomnožimo vrednost v kubičnih metrih z 1000000. \n \n Primer: 12 m³ * 1000000 = 12000000 cm³");

            pretvorba.Add("Liter-Kubični meter", "Pretvarjanje iz litrov v kubične metre poteka tako, da delimo vrednost v litrih z 1000. \n \n Primer: 12l / 1000 = 0.012 m³");
            pretvorba.Add("Liter-Liter", "Pretvarjanje iz litrov v litre poteka tako, da pomnožimo vrednost v litrih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12l * 1 = 12l");
            pretvorba.Add("Liter-Deciliter", "Pretvarjanje iz litrov v decilitre poteka tako, da pomnožimo vrednost v litrih z 10. \n \n Primer: 12l * 10 = 120 dl");
            pretvorba.Add("Liter-Kubični centimeter", "Pretvarjanje iz litrov v kubične centimetre poteka tako, da pomnožimo vrednost v litrih z 1000. \n \n Primer: 12l * 1000 = 12000 cm³");

            pretvorba.Add("Deciliter-Kubični meter","Pretvarjanje iz decilitrov v kubični meter poteka tako da. Delimo vrednost v decilitrih z 10000. \n \n Primer: 12dl / 10000 = 0.0012");
            pretvorba.Add("Deciliter-Liter", "Pretvarjanje iz decilitrov v litre poteka tako da. Delimo vrednost v decilitrih z 10. \n \n Primer: 12dl / 10 = 1.2");
            pretvorba.Add("Deciliter-Deciliter", "Pretvarjanje iz decilitrov v decilitre poteka tako, da pomnožimo vrednost v decilitrih z 1. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12dl * 1 = 12dl");
            pretvorba.Add("Deciliter-Kubični centimeter", "Pretvarjanje iz decilitrov v kubične centimetre poteka tako, da pomnožimo vrednost v decilitrih z 100. \n \n Primer: 12dl * 100 = 1200 cm³");

            pretvorba.Add("Kubični centimeter-Kubični meter", "Pretvarjanje iz cm³ v m³ poteka tako, da delimo vrednost v kubičnih metrih z 1000000. Kjer je rezultat enak začetni vrednosti. \n \n Primer: 12 cm³ / 1000000 = 0.000012 m³");
            pretvorba.Add("Kubični centimeter-Liter", "Pretvarjanje iz cm³ v litre poteka tako, da vrednost v kubičnih metrih delimo z 1000. \n \n Primer: 12 cm³ / 1000 = 0.012 l");
            pretvorba.Add("Kubični centimeter-Deciliter", "Pretvarjanje iz cm³ v decilitre poteka tako, da vrednost v kubičnih metrih delimo z 100. \n \n Primer: 12 cm³ / 100 = 0.12 dl");
            pretvorba.Add("Kubični centimeter-Kubični centimeter", "Pretvarjanje iz cm³ v cm³ poteka tako, da pomnožimo vrednost v kubičnih metrih z 1. \n \n Primer: 12 cm³ * 1 = 12 cm³");

            pretvorba.Add("Galon-Galon", "Pretvarjanje iz galona v galon poteka tako, da pomnožimo vrednost v galonih z 1. \n \n Primer: 12 gal * 1 = 12 gal");
            pretvorba.Add("Galon-Unča", "Pretvarjanje iz galona v unče poteka tako, da pomnožimo vrednost v galonih z 128. \n \n Primer: 12 gal * 128 = 1536 oz");
            pretvorba.Add("Galon-Kvart", "Pretvarjanje iz galona v kvarte poteka tako, da pomnožimo vrednost v galonih z 4. \n \n Primer: 12 gal * 4 = 48 qt");

            pretvorba.Add("Unča-Galon", "Pretvarjanje iz unča v galon poteka tako, da delimo vrednost v unčih z 128. \n \n Primer: 12 oz / 128 = 0.09375 gal");
            pretvorba.Add("Unča-Unča", "Pretvarjanje iz unča v unč poteka tako, da pomnožimo vrednost v unčih z 1. \n \n Primer: 12 oz * 1 = 12 oz");
            pretvorba.Add("Unča-Kvart", "Pretvarjanje iz unča v kvart poteka tako, da delimo vrednost v unčih z 32. \n \n Primer: 12 oz / 32 = 0.375 qt");

            pretvorba.Add("Kvart-Galon", "Pretvorba iz kvartov v galone poteka tako, da delimo vrednost v kvartih z 4. \n \n Primer: 12 qt / 4 = 3 gal");
            pretvorba.Add("Kvart-Unča", "Pretvorba iz kvartov v unče poteka tako, da pomnožimo vrednost v kvartih z 32. \n \n Primer: 12 qt * 32 = 384 oz");
            pretvorba.Add("Kvart-Kvart", "Pretvarjanje iz kvarta v kavrt poteka tako, da pomnožimo vrednost v kvartih z 1. \n \n Primer: 12 qt * 1 = 12 qt");

            pretvorba.Add("Galon-Kubični meter", "Pretvorba z galonov v kubične metre poteka tako, da delimo vrednost v galonih z 264.172. \n \n Primer: 12 gal / 264.172 = 0.0454249 m3");
            pretvorba.Add("Galon-Liter", "Pretvorba z galonov v litre poteka tako, da pomnožimo vrednost v galonih z 3.785. \n \n Primer: 12 gal * 3.785 = 45.4249 l");
            pretvorba.Add("Galon-Deciliter", "Pretvorba z galonov v decilitre poteka tako, da delimo vrednost v galonih z 3.. \n \n Primer: 12 gal / 264.172 = 0.0454249 m3");
            pretvorba.Add("Galon-Kubični centimeter", "Pretvorba z galonov v kubične centimetre poteka tako, da pomnožimo vrednost v galonih z 3785.412. \n \n Primer: 12 gal * 3785.412 = 45424.9 m3");

            pretvorba.Add("Unča-Kubični meter", "Pretvorba iz unč v kubične metre poteka tako, da vrednost v unčih delimo z 33814.023. \n \n Primer: 12 oz / 33814.023 = 0.000354882 m3");
            pretvorba.Add("Unča-Liter", "Pretvorba iz unč v litre poteka tako, da vrednost v unčih delimo z 33.814. \n \n Primer: 12 oz / 33.814 = 0.354882 l");
            pretvorba.Add("Unča-Deciliter", "Pretvorba iz unč v decilitre poteka tako, da vrednost v unčih delimo z 3.381. \n \n Primer: 12 oz / 3.381 = 3.54882 dl");
            pretvorba.Add("Unča-Kubični centimeter", "Pretvorba iz unč v kubične centimetre poteka tako, da vrednost v pomnožimo z 29.574. \n \n Primer: 12 oz * 29.574 = 354.882 cm3");

            pretvorba.Add("Kvart-Kubični meter", "Pretvorba iz kvarta v kubični meter poteka tako, da vrednost v kvartih delimo z 1056.688. \n \n Primer: 12 qt / 1056.688 = 0.0113562 m3");
            pretvorba.Add("Kvart-Liter", "Pretvorba iz kvarta v litre poteka tako, da vrednost v kvartih delimo z 1.057. \n \n Primer: 12 qt / 1.057 = 11.3562 l");
            pretvorba.Add("Kvart-Deciliter", "Pretvorba iz kvarta v decilitre poteka tako, da vrednost v kvartih pomnožimo z 9.464. \n \n Primer: 12 qt * 9.464 = 113.562 dl");
            pretvorba.Add("Kvart-Kubični centimeter", "Pretvorba iz kvarta v kubične centimetre poteka tako, da vrednost v kvartih pomnožimo z 946.4. \n \n Primer: 12 qt * 946.4 = 11356.2 cm3");

            pretvorba.Add("Kubični meter-Galon", "Pretvarjanje iz kubičnih metrov v galone poteka tako, da vrednost v kubičnih metrih pomnožimo z 264.172. \n \n Primer: 12 m3 * 264.172 = 3170.06 gal");
            pretvorba.Add("Kubični meter-Unča", "Pretvarjanje iz kubičnih metrov v unče poteka tako, da vrednost v kubičnih metrih pomnožimo z 33814.023. \n \n Primer: 12 m3 * 33814.023 = 405768 oz");
            pretvorba.Add("Kubični meter-Kvart", "Pretvarjanje iz kubičnih metrov v kvarte poteka tako, da vrednost v kubičnih metrih pomnožimo z 1056.688. \n \n Primer: 12 m3 * 1056.688 = 1056.69 qt");

            pretvorba.Add("Kubični centimeter-Galon", "Pretvarjanje iz kubičnih centimetrov v galone poteka tako, da vrednost v kubičnih centimetrih delimo z 3785.412. \n \n Primer: 12 cm3 / 3785.412 = 0.000264172 gal");
            pretvorba.Add("Kubični centimeter-Unča", "Pretvarjanje iz kubičnih centimetrov v unče poteka tako, da vrednost v kubičnih centimetrih delimo z 29.574. \n \n Primer: 12 cm3 / 29.574 = 0.033814 oz");
            pretvorba.Add("Kubični centimeter-Kvart", "Pretvarjanje iz kubičnih centimetrov v kvarte poteka tako, da vrednost v kubičnih centimetrih delimo z 946.353. \n \n Primer: 12 cm3 / 946.353 = 0.00105669 qt");

            pretvorba.Add("Liter-Galon", "Pretvarjanje iz litrov v galone poteka tako, da vrednost v litrih delimo z 3.785. \n \n Primer: 12 l / 3785.412 = 0.264172 gal");
            pretvorba.Add("Liter-Unča", "Pretvarjanje iz litrov v unče poteka tako, da vrednost v litrih pomnožimo z 33.814. \n \n Primer: 12 l * 3785.412 = 405.768 oz");
            pretvorba.Add("Liter-Kvart", "Pretvarjanje iz litrov v kvarte poteka tako, da vrednost v litrih pomnožimo z 1.057. \n \n Primer: 12 l * 1.057 = 12.6803 qt");

            pretvorba.Add("Deciliter-Galon", "Pretvarjanje iz decilitrov v galone poteka tako, da vrednost v decilitrih delimo z 37.854. \n \n Primer: 12 dl / 37.854 = 0.0264172 gal");
            pretvorba.Add("Deciliter-Unča", "Pretvarjanje iz decilitrov v unče poteka tako, da vrednost v decilitrih pomnožimo z 3.381. \n \n Primer: 12 dl * 3785.412 = 40.5768 oz");
            pretvorba.Add("Deciliter-Kvart", "Pretvarjanje iz decilitrov v kvarte poteka tako, da vrednost v decilitrih delimo z 9.464. \n \n Primer: 12 dl / 9.464 = 1.26803 qt");

            pretvorba.Add("Kvadratni kilometri-Kvadratni kilometri", "Pretvarjanje iz kvadratnih kilometrov v kvadratne kilometre poteka tako, da pomnožimo vrednost v kvadratnih kilometrih z 1. \n \n Primer: 12 km2 * 1 = 12 km2");
            pretvorba.Add("Kvadratni kilometri-Hektari", "Pretvarjanje iz kvadratnih kilometrov v hektare poteka tako, da pomnožimo vrednost v kvadratnih kilometrih z 100. \n \n Primer: 12 km2 * 100 = 1200 ha");
            pretvorba.Add("Kvadratni kilometri-Kvadratni metri", "Pretvarjanje iz kvadratnih kilometrov v kvadratne centimetre poteka tako, da pomnožimo vrednost v kvadratnih metrih z 1000000. \n \n Primer: 12 km2 * 1000000 = 12000000 m2");
            pretvorba.Add("Kvadratni kilometri-Kvadratni centimetri", "Pretvarjanje iz kvadratnih kilometrov v kvadratne centimetre poteka tako, da pomnožimo vrednost v kvadratnih centimetrih z 10000000000. \n \n Primer: 12 km2 * 10000000000 = 120000000000 cm2");

            pretvorba.Add("Hektari-Hektari", "Pretvarjanje iz heaktarov v hektare poteka tako, da pomnožimo vrednost v hektarih z 1. \n \n Primer: 12 ha * 1 = 12 ha");
            pretvorba.Add("Hektari-Kvadratni kilometri", "Pretvarjanje iz hektarov v kvadratne kilometre poteka tako, da delimo vrednost v hektarih z 100. \n \n Primer: 12 ha / 100 = 0.12 km3");
            pretvorba.Add("Hektari-Kvadratni metri", "Pretvarjanje iz hektarov v kvadratne metre poteka tako, da pomnožimo vrednost v hektarih z 10000. \n \n Primer: 12 ha * 10000 = 120000 m2");
            pretvorba.Add("Hektari-Kvadratni centimetri", "Pretvarjanje iz heaktarov v kvadratne centimetre poteka tako, da pomnožimo vrednost v hektarih z 100000000. \n \n Primer: 12 ha * 100000000 = 1200000000 cm2");

            pretvorba.Add("Kvadratni centimetri-Kvadratni kilometri", "Pretvarjanje iz kvadratnih centimetrov v kvadratne kilometre poteka tako, da delimo vrednost v kvadratnih centimetrih z 10000000000. \n \n Primer: 12 cm2 / 10000000000 = 0.000000012 km2");
            pretvorba.Add("Kvadratni centimetri-Hektari", "Pretvarjanje iz kvadratnih centikilometrov v hektare poteka tako, da delimo vrednost v kvadratnih centimetrih z 100000000. \n \n Primer: 12 km2 / 100000000 = 0.00000012 ha");
            pretvorba.Add("Kvadratni centimetri-Kvadratni metri", "Pretvarjanje iz kvadratnih centimetrov v kvadratne metre poteka tako, da deljimo vrednost v kvadratnih centimetrih z 10000. \n \n Primer: 12 km2 / 10000 = 0.0012 m2");
            pretvorba.Add("Kvadratni centimetri-Kvadratni centimetri", "Pretvarjanje iz kvadratnih centimetrov v kvadratne centimetre poteka tako, da pomnožimo vrednost v kvadratnih kilometrih z 1. \n \n Primer: 12 cm2 * 1 = 12 cm2");

            pretvorba.Add("Kvadratni metri-Kvadratni kilometri", "Pretvarjanje iz kvadratnih metrov v kvadratne kilometre poteka tako, da delimo vrednost v kvadratnih metrih z 1000000. \n \n Primer: 12 m2 / 1000000 = 0.000012 km2");
            pretvorba.Add("Kvadratni metri-Hektari", "Pretvarjanje iz kvadratnih centikilometrov v hektare poteka tako, da delimo vrednost v kvadratnih metrih z 10000. \n \n Primer: 12 m2 / 10000 = 0.0012 ha");
            pretvorba.Add("Kvadratni metri-Kvadratni metri", "Pretvarjanje iz kvadratnih centimetrov v kvadratne metre poteka tako, da pomnožimo vrednost v kvadratnih metrih z 1. \n \n Primer: 12 m2 * 1 = 12 m2");
            pretvorba.Add("Kvadratni metri-Kvadratni centimetri", "Pretvarjanje iz kvadratnih centimetrov v kvadratne centimetre poteka tako, da pomnožimo vrednost v kvadratnih metrih z 10000. \n \n Primer: 12 m2 * 10000 = 120000 cm2");

            pretvorba.Add("Kvadratna milja-Kvadratna milja", "Pretvarjanje iz kvadratnih milj v kvadratne milje poteka tako, da pomnožimo vrednost v kvadratnih miljah z 1. \n \n Primer: 12 mi2 * 1 = 12 mi2");
            pretvorba.Add("Kvadratna milja-Aker", "Pretvarjanje iz kvadratnih milj v akre poteka tako, da pomnožimo vrednost v kvadratnih miljah z 640. \n \n Primer: 12 mi2 * 640 = 7680 ac");

            pretvorba.Add("Aker-Kvadratna milja", "Pretvarjanje iz kvadratnih milj v kvadratne milje poteka tako, da delimo vrednost v kvadratnih miljah z 1. \n \n Primer: 12 ac / 640 = 0.01875 mi2");
            pretvorba.Add("Aker-Aker", "Pretvarjanje iz akrov v akre poteka tako, da pomnožimo vrednost v akrih z 1. \n \n Primer: 12 ac * 1 = 12 ac");

            pretvorba.Add("Aker-Kvadratni kilometri", "Pretvarjanje iz akrov v kvadratne kilometre poteka tako, da delimo vrednost v akrih z 247.105. \n \n Primer: 12 ac / 247.105 = 0.0485623 km2");
            pretvorba.Add("Aker-Hektari", "Pretvarjanje iz akrov v hektare poteka tako, da pomnožimo vrednost v akrih z 2.471. \n \n Primer: 12 ac * 2.471 = 4.85623 ha");
            pretvorba.Add("Aker-Kvadratni metri", "Pretvarjanje iz akrov v kvadratne metre poteka tako, da pomnožimo vrednost v akrih z 4046.856. \n \n Primer: 12 ac * 4046.856 = 48562.3 m2");
            pretvorba.Add("Aker-Kvadratni centimetri", "Pretvarjanje iz akrov v kvadratne centimetre poteka tako, da pomnožimo vrednost v akrih z 4.047e+7. \n \n Primer: 12 ac * 4.047e+7 = 4.856e+8 cm2");

            pretvorba.Add("Kvadratna milja-Kvadratni kilometri", "Pretvarjanje iz kvadratnih milj v kvadratne kilometre poteka tako, da pomnožimo vrednost v kvadratnih miljah z 2.59. \n \n Primer: 12 mi2 * 2.59 = 31.0799 km2");
            pretvorba.Add("Kvadratna milja-Hektari", "Pretvarjanje iz kvadratnih milj v hektare poteka tako, da pomnožimo vrednost v kvadratnih miljah z 258.999. \n \n Primer: 12 mi2 * 258.999 = 3107.99 ha");
            pretvorba.Add("Kvadratnia milja-Kvadratni metri", "Pretvarjanje iz kvadratnih milj v kvadratne metre poteka tako, da pomnožimo vrednost v kvadratnih miljah z 2.59e+6. \n \n Primer: 12 mi2 * 2.59e+6 = 3.108e+7 m2");
            pretvorba.Add("Kvadratna milja-Kvadratni centimetri", "Pretvarjanje iz kvadratnih milj v kvadratne centimetre poteka tako, da pomnožimo vrednost v kvadratnih miljah z 2.59e+10. \n \n Primer: 12 mi2 * 2.59e+10 = 3.108e+11 cm2");

            pretvorba.Add("Kvadratni kilometri-Kvadratna milja", "Pretvarjanje iz kvadratnih kilometrov v kvadratne milje poteka tako, da delimo vrednost v kvadratnih kilometrih z 2.59. \n \n Primer: 12 km2 / 2.59 = 4.63323 mi2");
            pretvorba.Add("Kvadratni kilometri-Aker", "Pretvarjanje iz kvadratnih kilometrov v akre poteka tako, da pomnožimo vrednost v kvadratnih kilometrih z 247.105. \n \n Primer: 12 km2 * 247.105 = 2965.26 ac");

            pretvorba.Add("Kvadratni metri-Kvadratna milja", "Pretvarjanje iz kvadratnih metrov v kvadratne milje poteka tako, da delimo vrednost v kvadratnih metrih z 2.59e+6. \n \n Primer: 12 m2 / 2.59e+6 = 4.63323e-6 mi2");
            pretvorba.Add("Kvadratni metri-Aker", "Pretvarjanje iz kvadratnih metrov v akre poteka tako, da deljimo vrednost v kvadratnih metrih z 4046.856. \n \n Primer: 12 m2 * 4046.856 = 0.00296526 ac");

            pretvorba.Add("Kvadratni centimetri-Kvadratna milja", "Pretvarjanje iz kvadratnih centimetrov v kvadratne milje poteka tako, da delimo vrednost v kvadratnih centimetrih z 2.59e+10. \n \n Primer: 12 cm2 / 2.59e+10 = 4.63323e-10 mi2");
            pretvorba.Add("Kvadratni centimetri-Aker", "Pretvarjanje iz kvadratnih centimetrov v akre poteka tako, da deljimo vrednost v kvadratnih centimetrih z 4.047e+7. \n \n Primer: 12 cm2 * 4.047e+7 = 2.96526e-7 ac");

            pretvorba.Add("Hektari-Kvadratna milja", "Pretvarjanje iz hektarov v kvadratne milje poteka tako, da delimo vrednost v hektarih z 258.999. \n \n Primer: 12 cm2 / 258.999 = 0.0463323 mi2");
            pretvorba.Add("Hektari-Aker", "Pretvarjanje iz hektarov v akre poteka tako, da pomnožimo vrednost v hektarih z 2.471. \n \n Primer: 12 cm2 * 2.471 = 29.6526 ac");

            pretvorba.Add("Kilometri-Kilometri", "Pretvarjanje iz kilometrov v kilometre poteka tako, da pomnožimo vrednost v kilometrih z 1. \n\n Primer: 12km * 1 = 12km");
            pretvorba.Add("Kilometri-Metri", "Pretvarjanje iz kilometrov v metre poteka tako, da pomnožimo vrednost v kilometrih z 1000. \n\n Primer: 12km * 1000 = 12000m");
            pretvorba.Add("Kilometri-Centimetri", "Pretvarjanje iz kilometrov v centimetre poteka tako, da pomnožimo vrednost v kilometrih z 100000. \n\n Primer: 12km * 100000 = 1200000cm");
            pretvorba.Add("Kilometri-Milimetri", "Pretvarjanje iz kilometrov v centimetre poteka tako, da pomnožimo vrednost v kilometrih z 1000000. \n\n Primer: 12km * 1000000 = 12000000mm");

            pretvorba.Add("Metri-Kilometri", "Pretvarjanje iz metrov v kilometre poteka tako, da delimo vrednost v metrih z 1000. \n\n Primer: 12m / 1000 = 0.012km");
            pretvorba.Add("Metri-Metri", "Pretvarjanje iz metrov v metre poteka tako, da pomnožimo vrednost v metrih z 1. \n\n Primer: 12m * 1 = 12m");
            pretvorba.Add("Metri-Centimetri", "Pretvarjanje iz metrov v centimetre poteka tako, da pomnožimo vrednost v metrih z 100. \n\n Primer: 12m * 100 = 1200cm");
            pretvorba.Add("Metri-Milimetri", "Pretvarjanje iz metrov v centimetre poteka tako, da pomnožimo vrednost v metrih z 1000. \n\n Primer: 12m * 1000 = 12000mm");

            pretvorba.Add("Centimetri-Kilometri", "Pretvarjanje iz centimetrov v kilometre poteka tako, da delimo vrednost v centimetrih z 100000. \n\n Primer: 12cm / 100000 = 0.00012km");
            pretvorba.Add("Centimetri-Metri", "Pretvarjanje iz centimetrov v metre poteka tako, da delimo vrednost v centimetrih z 100. \n\n Primer: 12cm / 100 = 0.12m");
            pretvorba.Add("Centimetri-Centimetri", "Pretvarjanje iz centimetrov v centimetre poteka tako, da pomnožimo vrednost v centimetrih z 1. \n\n Primer: 12cm * 1 = 12cm");
            pretvorba.Add("Centimetri-Milimetri", "Pretvarjanje iz centimetrov v centimetre poteka tako, da pomnožimo vrednost v centimetrih z 10. \n\n Primer: 12cm * 10 = 120mm");

            pretvorba.Add("Milimetri-Kilometri", "Pretvarjanje iz milimetrov v kilometre poteka tako, da delimo vrednost v milimetrih z 1000000. \n\n Primer: 12mm / 1000000 = 0.0000012km");
            pretvorba.Add("Milimetri-Metri", "Pretvarjanje iz milimetrov v metre poteka tako, da delimo vrednost v milimetrih z 1000. \n\n Primer: 12mm / 1000 = 0.012m");
            pretvorba.Add("Milimetri-Centimetri", "Pretvarjanje iz milimetrov v centimetre poteka tako, da delimo vrednost v milimetrih z 10. \n\n Primer: 12mm / 10 = 1.2cm");
            pretvorba.Add("Milimetri-Milimetri", "Pretvarjanje iz milimetrov v centimetre poteka tako, da pomnožimo vrednost v milimetrih z 1. \n\n Primer: 12mm * 11 = 12mm");

            pretvorba.Add("Milja-Milja", "Pretvarjanje iz milj v milje poteka tako, da množimo vrednost v miljah z 1. \n \n Primer: 12mi * 1 = 12mi");
            pretvorba.Add("Milja-Jard", "Pretvarjanje iz milj v jarde poteka tako, da množimo vrednost v miljah z 1760. \n \n Primer: 12mi * 1760 = 21120yd");
            pretvorba.Add("Milja-Cevelj", "Pretvarjanje iz milj v čevlje poteka tako, da množimo vrednost v milja z 5280. \n \n Primer: 12mi * 5280 = 63360ft");
            pretvorba.Add("Milja-Palec", "Pretvarjanje iz milj v palce poteka tako, da množimo vrednost v milja z 63360. \n \n Primer: 12mi * 63360 = 760320\"");

            pretvorba.Add("Jard-Milja", "Pretvarjanje iz jardov v milje poteka tako, da delimo vrednost v jardih z 1760. \n \n Primer: 12yd / 1760 = 0.00681818mi");
            pretvorba.Add("Jard-Jard", "Pretvarjanje iz jardov v jarde poteka tako, da množimo vrednost v jardih z 1. \n \n Primer: 12yd * 11 = 12yd");
            pretvorba.Add("Jard-Cevelj", "Pretvarjanje iz jardov v čevlje poteka tako, da množimo vrednost v jardih z 3. \n \n Primer: 12yd * 3 = 36ft");
            pretvorba.Add("Jard-Palec", "Pretvarjanje iz jardob v palce poteka tako, da množimo vrednost v jardih z 36. \n \n Primer: 12yd * 36 = 432\"");

            pretvorba.Add("Cevelj-Milja", "Pretvarjanje iz čeveljev v milje poteka tako, da delimo vrednost v čevljnih z 5280. \n \n Primer: 12ft / 5280 = 0.00227273mi");
            pretvorba.Add("Cevelj-Jard", "Pretvarjanje iz čevljev v jarde poteka tako, da delimo vrednost v čevljih z 3. \n \n Primer: 12ft / 3 = 4yd");
            pretvorba.Add("Cevelj-Cevelj", "Pretvarjanje iz čevljev v čevlje poteka tako, da množimo vrednost v čevljih z 1. \n \n Primer: 12ft * 1 = 12ft");
            pretvorba.Add("Cevelj-Palec", "Pretvarjanje iz čevljev v palce poteka tako, da množimo vrednost v čevljih z 12. \n \n Primer: 12ft * 12 = 144\"");

            pretvorba.Add("Palec-Milja", "Pretvarjanje iz palcev v milje poteka tako, da delimo vrednost v palcih z 63360. \n \n Primer: 12\" / 63360 = 0.000189394mi");
            pretvorba.Add("Palec-Jard", "Pretvarjanje iz palcev v jarde poteka tako, da delimo vrednost v palcih z 36. \n \n Primer: 12\" / 36 = 0.33333yd");
            pretvorba.Add("Palec-Cevelj", "Pretvarjanje iz palcev v čevlje poteka tako, da delimo vrednost v palcih z 12. \n \n Primer: 12\" / 12 = 1ft");
            pretvorba.Add("Palec-Palec", "Pretvarjanje iz palcev v palce poteka tako, da množimo vrednost v palcih z 1. \n \n Primer: 12\" * 1 = 12\"");

            pretvorba.Add("Kilometri-Milja", "Pretvarjanje iz kilometrov v milje poteka tako, da delimo vrednost v kilometrih z 1.609. \n \n Primer: 12km / 1.609 = 7.45645mi");
            pretvorba.Add("Kilometri-Jard", "Pretvarjanje iz kilometrov v jard poteka tako, da pomnožimo vrednost v kilometrih z 1093.613. \n \n Primer: 12km * 1093.613 = 13123.4yd");
            pretvorba.Add("Kilometri-Cevelj", "Pretvarjanje iz kilometrov v čevlje poteka tako, da pomnožimo vrednost v kilometrih z 3280.84. \n \n Primer: 12km * 3280.84 = 39370.1ft");
            pretvorba.Add("Kilometri-Palec", "Pretvarjanje iz kilometrov v palce poteka tako, da pomnožimo vrednost v kilometrih z 39370.079. \n \n Primer: 12km * 39370.079 = 472441\"");

            pretvorba.Add("Metri-Milja", "Pretvarjanje iz metrov v milje poteka tako, da delimo vrednost v metrih z 1609.344. \n \n Primer: 12m / 1609.344 = 0.00745645mi");
            pretvorba.Add("Metri-Jard", "Pretvarjanje iz metrov v jard poteka tako, da pomnožimo vrednost v metrih z 1.094. \n \n Primer: 12m * 1.094 = 13.1234yd");
            pretvorba.Add("Metri-Cevelj", "Pretvarjanje iz metrov v čevlje poteka tako, da pomnožimo vrednost v metrih z 3,281. \n \n Primer: 12m * 3,281 = 3,28084ft");
            pretvorba.Add("Metri-Palec", "Pretvarjanje iz metrov v palce poteka tako, da pomnožimo vrednost v metrih z 39,37. \n \n Primer: 12m * 39,37 = 472.441\"");

            pretvorba.Add("Centimetri-Milja", "Pretvarjanje iz centimetrov v milje poteka tako, da delimo vrednost v centimetrih z 160934,4. \n \n Primer: 12cm / 160934,4 = 7.4565e-5mi");
            pretvorba.Add("Centimetri-Jard", "Pretvarjanje iz centimetrov v jard poteka tako, da delimo vrednost v centimetrih z 91,44. \n \n Primer: 12cm / 91,44 = 0,0109361yd");
            pretvorba.Add("Centimetri-Cevelj", "Pretvarjanje iz centimetrov v čevlje poteka tako, da delimo vrednost v centimetrih z 30,48. \n \n Primer: 12cm / 30,48 = 0.393701ft");
            pretvorba.Add("Centimetri-Palec", "Pretvarjanje iz centimetrov v palce poteka tako, da delimo vrednost v centimetrih z 2,54. \n \n Primer: 12cm / 2,54 = 4.72441\"");

            pretvorba.Add("Milimetri-Milja", "Pretvarjanje iz milimetrov v milje poteka tako, da delimo vrednost v milimetrih z 1,609e+6. \n \n Primer: 12mm / 1,609e+6 = 7.4565e-6mi");
            pretvorba.Add("Milimetri-Jard", "Pretvarjanje iz milimetrov v jard poteka tako, da delimo vrednost v milimetrih z  914,4. \n \n Primer: 12mm / 914,4 = 0.0131234yd");
            pretvorba.Add("Milimetri-Cevelj", "Pretvarjanje iz milimetrov v čevlje poteka tako, da delimo vrednost v milimetrih z 30,48. \n \n Primer: 12mm / 30,48 = 0.393701ft");
            pretvorba.Add("Milimetri-Palec", "Pretvarjanje iz milimetrov v palce poteka tako, da delimo vrednost v milimetrih z 25,4. \n \n Primer: 12mm / 25,4 = 0.472441\"");

            pretvorba.Add("Milja-Kilometri", "Pretvarjanje iz milj v kilometre poteka tako, da pomnožimo vrednost v miljah z 1,609. \n \n Primer: 12 mi * 1,609 = 19,3121 km");
            pretvorba.Add("Milja-Metri", "Pretvarjanje iz milj v metre poteka tako, da pomnožimo vrednost v miljah z 160,934. \n \n Primer: 12 mi * 160,934 = 19312,1 m");
            pretvorba.Add("Milja-Centimetri", "Pretvarjanje iz milj v centimetre poteka tako, da pomnožimo vrednost v miljah z 160934,4. \n \n Primer: 12 mi * 160,934 = 1,931e+6 cm");
            pretvorba.Add("Milja-Milimetri", "Pretvarjanje iz milj v centimetre poteka tako, da pomnožimo vrednost v miljah z 1,609e+6. \n \n Primer: 12 mi * 160,934 = 1,931e+7 mm");

            pretvorba.Add("Jard-Kilometri", "Pretvarjanje iz jardov v kilometre poteka tako, da delimo vrednost v jardih z 1093,613. \n \n Primer: 12 yd / 1093,613 = 0.0109728 km");
            pretvorba.Add("Jard-Metri", "Pretvarjanje iz jardov v metre poteka tako, da delimo vrednost v jardih z 1,094. \n \n Primer: 12 yd / 1,094 = 10,9728 m");
            pretvorba.Add("Jard-Centimetri", "Pretvarjanje iz jardov v centimetre poteka tako, da pomnožimo vrednost v jardih z 91,44. \n \n Primer: 12 yd * 91,44 = 1097,28 cm");
            pretvorba.Add("Jard-Milimetri", "Pretvarjanje iz jardov v centimetre poteka tako, da pomnožimo vrednost v jardih z 914,4. \n \n Primer: 12 yd * 914,4 = 10972,8 mm");

            pretvorba.Add("Cevelj-Kilometri", "Pretvarjanje iz čevljev v kilometre poteka tako, da delimo vrednost v čevljih z 3280,84. \n \n Primer: 12 ft / 3280,84 = 0,0036576 km");
            pretvorba.Add("Cevelj-Metri", "Pretvarjanje iz čevljev v metre poteka tako, da delimo vrednost v čevljih z 3,281. \n \n Primer: 12 ft / 3,281 = 3,6576 m");
            pretvorba.Add("Cevelj-Centimetri", "Pretvarjanje iz čevljev v centimetre poteka tako, da pomnožimo vrednost v čevljih z 30,48. \n \n Primer: 12 ft * 30,48 = 365,76 cm");
            pretvorba.Add("Cevelj-Milimetri", "Pretvarjanje iz čevljev v centimetre poteka tako, da pomnožimo vrednost v čevljih z 30,475. \n \n Primer: 12 ft * 30,475 = 3657,6 mm");

            pretvorba.Add("Palec-Kilometri", "Pretvarjanje iz palcev v kilometre poteka tako, da delimo vrednost v palcih z 3280,84. \n \n Primer: 12\" / 3280,84 = 0,0036576 km");
            pretvorba.Add("Palec-Metri", "Pretvarjanje iz palcev v metre poteka tako, da delimo vrednost v palcih z 3,281. \n \n Primer: 12\" / 3,281 = 3,6576 m");
            pretvorba.Add("Palec-Centimetri", "Pretvarjanje iz palcev v centimetre poteka tako, da pomnožimo vrednost v palcih z 30,48. \n \n Primer: 12\" * 30,48 = 365,76 cm");
            pretvorba.Add("Palec-Milimetri", "Pretvarjanje iz palcev v centimetre poteka tako, da pomnožimo vrednost v palcih z 30,475. \n \n Primer: 12\" * 30,475 = 3657,6 mm");


            label1.Text = deljeno[0];
            label3.Text = mere[deljeno[0]];
            label5.Text = "Pretvarjanje " + skupaj.ToLower();
            label6.Text = pretvorba[skupaj];

            if(deljeno[0] == "Celzij")
            {
                label7.ImageIndex = 2;
                label7.Text = "Anders Celsius";
            }else if(deljeno[0] == "Kelvin")
            {
                label7.ImageIndex = 0;
                label7.Text = "Lord Kelvin";
            }else if(deljeno[0] == "Fahrenheit")
            {
                label7.ImageIndex = 1;
                label7.Text = "Daniel Fahrenheit";
            }else if(lokacija == "prostornina")
            {
                label7.ImageIndex = 3;
            }else if(lokacija == "povrsina")
            {
                label7.ImageIndex = 4;
            }else if(lokacija == "dolzina")
            {
                label7.ImageIndex = 5;
            }

            if(deljeno[0] == deljeno[1])
            {
                label2.Text = "";
                label4.Text = "";
            }
            else
            {
                label2.Text = deljeno[1];
                label4.Text = mere[deljeno[1]];
            }
        }

        private void Info_Load(object sender, EventArgs e)
        {

        }

        private void Button2_Click(object sender, EventArgs e)
        {
            if(loc == "temperatura")
            {
                temperatura m = new temperatura();
                m.Show();
                this.Hide();
            }else if(loc == "povrsina")
            {
                povrsina m = new povrsina();
                m.Show();
                this.Hide();
            }else if(loc == "dolzina")
            {
                dolzina m = new dolzina();
                m.Show();
                this.Hide();
            }else if(loc == "prostornina")
            {
                Prostornina m = new Prostornina();
                m.Show();
                this.Hide();
            }
            else
            {
                Form1 m = new Form1();
                m.Show();
                this.Hide();
            }
            
        }

        private void Label3_Click(object sender, EventArgs e)
        {

        }

        private void Panel1_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
