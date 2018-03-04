package com.peterjamesbabiera.itour_android.logic;

import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class AttractionLogic {

    private static AttractionLogic instance;

    public static AttractionLogic getInstance() {
        if (instance == null) {
            instance = new AttractionLogic();
        }
        return instance;
    }

    public List<Attraction> getEvent() {
        List<Attraction> events = new ArrayList<>();

        Attraction dinagyang = new Attraction();
        dinagyang.setImageId(R.drawable.ic_dinagyang);
        dinagyang.setName("Dinagyang");
        dinagyang.setInfo("The Iloilo Dinagyang Festival is a showcase of the rich heritage, " +
                "colorful history, passionate devotion, and fun-loving spirit " +
                "of the Ilonggo people. The festival traces its roots as a " +
                "thanksgiving celebration in honor of Senyor Santo Niño, the child Jesus." +
                " Today, it has grown to be one of the Philippines’ most spectacular religious" +
                " and cultural festivals.");
        dinagyang.setInfoImageId(R.drawable.ic_dinagyang2);
        events.add(dinagyang);

        Attraction parrawRegatta = new Attraction();
        parrawRegatta.setImageId(R.drawable.ic_parraw_regatta);
        parrawRegatta.setName("Parraw Regatta");
        parrawRegatta.setInfo("The Paraw regatta is a race among seafarers on colorful " +
                "sailboats called Paraws in the straits between Guimaras  Island and the " +
                "city of Iloilo. The present-day paraw managed to maintain its original " +
                "design from the sailboats of the first settlers from Borneo who were " +
                "in search of a peaceful home in 1212 A.D. Surviving the centuries, " +
                "the paraws have become a vital part of the Filipino seafaring life.");
        parrawRegatta.setInfoImageId(R.drawable.ic_parraw_regatta2);
        events.add(parrawRegatta);

        return events;
    }

    public List<Attraction> getSites() {
        List<Attraction> sites = new ArrayList<>();

        Attraction jaroChurch = new Attraction();
        jaroChurch.setImageId(R.drawable.ic_jaro_church);
        jaroChurch.setName("Jaro Cathedral");
        jaroChurch.setInfo("The Jaro Cathedral (Church of St. Elizabeth of Hungary) was built in 1864, " +
                "the year the district was named a diocese by Pope Pius the IX, by order of His Grace " +
                "Mariano Cuartero, first bishop of Jaro. Destroyed in the quake of January 1948 and restored " +
                "by order of His Excellency Jose Ma. Cuenco, first archbishop of Jaro in 1956. The cathedral’s " +
                "style is basically Baroque, with the addition of Gothic elements over many renovations.");
        jaroChurch.setInfoImageId(R.drawable.ic_jaro_church2);
        jaroChurch.setLatitude(10.69);
        jaroChurch.setLongitude(125.55);
        sites.add(jaroChurch);

        Attraction moloChurch = new Attraction();
        moloChurch.setImageId(R.drawable.ic_molo_church);
        moloChurch.setName("Molo Cathedral");
        moloChurch.setInfo("Molo Cathedral is a famous Spanish-colonial church and heritage site in Molo District. " +
                "It known for the prominent red spires that crown its tall bell towers and as “the feminist church” " +
                "because of the all-women ensemble of saints represented in 16 statues perched on the aisle pillars. " +
                "Built in neogothic style, the church is one of the Iloilo City’s most familiar landmarks and top " +
                "tourist attractions.");
        moloChurch.setInfoImageId(R.drawable.ic_molo_church2);
        moloChurch.setLatitude(10.7);
        moloChurch.setLongitude(122.55);
        sites.add(moloChurch);

        Attraction iloiloBusinessPark = new Attraction();
        iloiloBusinessPark.setImageId(R.drawable.ic_iloilo_business_park);
        iloiloBusinessPark.setName("Iloilo Business Park");
        iloiloBusinessPark.setInfo("Iloilo Business Park is Megaworld’s biggest township in Western Visayas, modelled " +
                "after the company’s ‘live-work-play-learn’ lifestyle township formula in the Philippines. Among " +
                "its successful townships include Eastwood City, known to be the Philippines’ first cyberpark; " +
                "McKinley Hill in Bonifacio Global City, Taguig; and Newport City in Pasay City, home of the famous " +
                "Resorts World Manila.");
        iloiloBusinessPark.setInfoImageId(R.drawable.ic_iloilo_business_park2);
        iloiloBusinessPark.setLatitude(10.714722);
        iloiloBusinessPark.setLongitude(122.544722);
        sites.add(iloiloBusinessPark);

        Attraction museoIloilo = new Attraction();
        museoIloilo.setImageId(R.drawable.ic_museo_iloilo);
        museoIloilo.setName("Museo Iloilo");
        museoIloilo.setInfo("Museo Iloilo, located along Bonifacio Drive in Iloilo City Proper, is the first gov’t " +
                "sponsored museum outside Metro Manila. The museum building was designed by Ilonggo architect Sergio " +
                "Penasales. The museum houses an impressive collection of Iloilo’s cultural heritage which includes stone " +
                "age native pottery; fossils; jewelry; burial sites; trade pottery from China , Annam and Siam; era photos. " +
                "Mementos and war relics; a British sunken ship; Spanish-era Filipino sculpture; and modern art done by " +
                "Ilonggo artists and craftsmen.");
        museoIloilo.setInfoImageId(R.drawable.ic_museo_iloilo2);
        museoIloilo.setLatitude(10.7027902);
        museoIloilo.setLongitude(122.5684267);
        sites.add(museoIloilo);

        Attraction calleReal = new Attraction();
        calleReal.setImageId(R.drawable.ic_calle_real);
        calleReal.setName("Calle Real");
        calleReal.setInfo("Calle Real (Royal Street in Spanish), officially named as J.M. Basa Street, is a historic street " +
                "located in the old downtown district Iloilo City Proper of Iloilo City, Iloilo, Philippines.The street often " +
                "referred to as the \"Escolta of Iloilo\".[1] It is home to several fine examples of historic luxury American " +
                "era neoclassical, beaux-arts, and art deco buildings. The street has been famous since the Spanish Era. However, " +
                "its importance has dwindled and the street has become less maintained; yet there have been efforts to revitalize " +
                "the street which includes the restoration of the historic buildings along the street and beautification projects.");
        calleReal.setInfoImageId(R.drawable.ic_calle_real2);
        calleReal.setLatitude(10.6945032);
        calleReal.setLongitude(122.5682651);
        sites.add(calleReal);

        Attraction casaRealDeIloilo = new Attraction();
        casaRealDeIloilo.setImageId(R.drawable.ic_casa_real_de_iloilo);
        casaRealDeIloilo.setName("Casa Real De Iloilo");
        casaRealDeIloilo.setInfo("The Old Capitol Building of Iloilo, renamed Casa Real De Iloilo in October 2016, is now considered " +
                "a National Historical Site by the NHI (National Historical Institute). It is the old edifice fronting the Arroyo " +
                "Fountain in Iloilo, Philippines.");
        casaRealDeIloilo.setInfoImageId(R.drawable.ic_casa_real_de_iloilo2);
        casaRealDeIloilo.setLatitude(10.7017068);
        casaRealDeIloilo.setLongitude(122.5689862);
        sites.add(casaRealDeIloilo);

        Attraction smallVille = new Attraction();
        smallVille.setImageId(R.drawable.ic_smallville);
        smallVille.setName("Small Ville");
        smallVille.setInfo("Smallville Complex is Iloilo’s nightlife capital and a popular dining and entertainment hub where Ilonggos " +
                "and visitors go to eat, drink, and spend a fun night out in the city. It is located along Diversion Road in Mandurriao " +
                "District, Iloilo City. A footwalk connects Smallville to the Iloilo River Esplanade to the south and a road joins it with " +
                "Atria Park District by Ayala on its northern side.");
        smallVille.setInfoImageId(R.drawable.ic_smallville2);
        smallVille.setLatitude(10.7054497);
        smallVille.setLongitude(122.551921);
        sites.add(smallVille);

        Attraction esplanade = new Attraction();
        esplanade.setImageId(R.drawable.ic_esplanade);
        esplanade.setName("Esplanade");
        esplanade.setInfo("The Iloilo Esplanade or simply the “esplanade” as locals call it is a peaceful promenade that runs alongside the " +
                "Iloilo River. It is one of best showcases of the city’s efforts to rehabilitate and protect the Iloilo River and promote " +
                "active lifestyles. It is also a popular tourist spot where visitors can enjoy a leisurely stroll and enjoy the serene views " +
                "along the river.");
        esplanade.setInfoImageId(R.drawable.ic_esplanade2);
        esplanade.setLatitude(10.702015);
        esplanade.setLongitude(122.544905);
        sites.add(esplanade);

        Attraction plazaLibertad = new Attraction();
        plazaLibertad.setImageId(R.drawable.ic_plaza_libertad);
        plazaLibertad.setName("Plaza Libertad");
        plazaLibertad.setInfo("Plaza Libertad is a historic plaza located in the heart of Iloilo City Proper, the downtown district, " +
                "at the southeastern end of Calle Real. It is where the flag of the first Philippine Republic was raised in triumph after " +
                "Spain surrendered Iloilo, her last capital in the Philippines, to the revolutionary forces led by Gen. Martin Delgado " +
                "on December 25, 1898.");
        plazaLibertad.setInfoImageId(R.drawable.ic_plaza_libertad2);
        plazaLibertad.setLatitude(10.6925);
        plazaLibertad.setLongitude(122.5736);
        sites.add(plazaLibertad);

        Attraction biscochoHaus = new Attraction();
        biscochoHaus.setImageId(R.drawable.ic_biscocho_haus);
        biscochoHaus.setName("Biscocho House");
        biscochoHaus.setInfo("When it comes to Ilonggo delicacies, one name has been standing out for almost three decades now. Biscocho " +
                "Haus has been around since 1975, an enterprise started by the late Dr. Carlos L. Guadarrama and Mrs. Therese J. Guadarrama. " +
                "Their specialty product was the Biscocho, a delicacy that has been a top choice for the Ilonggo’s snacks. Not long after, " +
                "families and friends have started sharing the goodness of Biscocho with those who live away from Iloilo City and even with " +
                "those out of the country. The growing demand for new variety inspired the Guadarramas to come up with new product lines, " +
                "most were honed in the kitchens of the Guadarrama-Jalandoni clans. Biscocho Haus bakes its own breads and turns them into the " +
                "famous Biscocho.");
        biscochoHaus.setInfoImageId(R.drawable.ic_biscocho_haus2);
        biscochoHaus.setLatitude(10.7011271);
        biscochoHaus.setLongitude(122.5670419);
        sites.add(biscochoHaus);

        Attraction deocampo = new Attraction();
        deocampo.setImageId(R.drawable.ic_deocampo);
        deocampo.setName("Deocampo");
        deocampo.setInfo("Deocampo: The Original Barquillos. I do not know if other Filipinos in other regions are also fond of pasalubongs, " +
                "but Iloilo certainly has A LOT to offer, when it comes to take home delicacies. Each pasalubong centre has a specialty. Iloilo " +
                "is not only the home of the best biscocho and butterscotch, but it is also home of one favourite snacks which is the usual escort " +
                "of a bowl of halo-halo or cup of ice cream: Barquillos. Deocampo offers the tastiest- the sweetest and every-crumb-is-worth-picking" +
                "-up-barquillos.");
        deocampo.setInfoImageId(R.drawable.ic_deocampo2);
        deocampo.setLatitude(10.7247802);
        deocampo.setLongitude(122.5523028);
        sites.add(deocampo);

        return sites;
    }

}
