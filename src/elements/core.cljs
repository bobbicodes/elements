(ns elements.core
   (:require [reagent.core :as reagent :refer [atom]]))

(defn new-board [n]
  (vec (repeat n (vec (repeat n "B")))))

(def board-size 1)

(defonce app-state
  (atom {:text "The Chemical Elements"
         :board (new-board board-size)}))

(def elements
[{:id 1 :name "Hydrogen" :abb "H" :img "https://upload.wikimedia.org/wikipedia/commons/8/83/Hydrogen_discharge_tube.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/0/03/En-Hydrogen_%28part_1%29.ogg"}
{:id 2 :name "Helium" :abb "He" :img "https://upload.wikimedia.org/wikipedia/commons/8/82/Helium_discharge_tube.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/1/16/Helium.ogg"}
{:id 3 :name "Lithium" :abb "Li" :img "https://upload.wikimedia.org/wikipedia/commons/a/ae/Lithium_paraffin.jpg" :audio "http://www.rsc.org/periodic-table/content/podcasts/Lithium.mp3?6.0.4.2"}
{:id 4 :name "Beryllium" :abb "Be" :img "https://upload.wikimedia.org/wikipedia/commons/0/0c/Be-140g.jpg" :audio "http://www.rsc.org/periodic-table/content/podcasts/Beryllium.mp3?6.0.4.2"}
{:id 5 :name "Boron" :abb "B" :img "https://upload.wikimedia.org/wikipedia/commons/1/19/Boron_R105.jpg" :audio "http://www.rsc.org/periodic-table/content/podcasts/Boron.mp3?6.0.4.2"}
{:id 6 :name "Carbon" :abb "C" :img "https://upload.wikimedia.org/wikipedia/commons/f/f0/Graphite-and-diamond-with-scale.jpg"}
{:id 7 :name "Nitrogen" :abb "N" :img "https://upload.wikimedia.org/wikipedia/commons/d/d2/Liquidnitrogen.jpg"}
{:id 8 :name "Oxygen" :abb "O" :img "https://upload.wikimedia.org/wikipedia/commons/c/c3/Liquid_oxygen_in_a_beaker_4.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/1/11/En-oxygen-article.ogg"}
{:id 9 :name "Fluorine" :abb "F" :img "https://upload.wikimedia.org/wikipedia/commons/9/91/Liquid_fluorine_tighter_crop.jpg"}
{:id 10 :name "Neon" :abb "Ne" :img "https://upload.wikimedia.org/wikipedia/commons/4/46/Neon_discharge_tube.jpg"}
{:id 11 :name "Sodium" :abb "Na" :img "https://upload.wikimedia.org/wikipedia/commons/2/27/Na_%28Sodium%29.jpg"}
{:id 12 :name "Magnesium" :abb "Mg" :img "https://upload.wikimedia.org/wikipedia/commons/5/5c/CSIRO_ScienceImage_2893_Crystalised_magnesium.jpg"}
{:id 13 :name "Aluminium" :abb "Al" :img "https://upload.wikimedia.org/wikipedia/commons/5/5d/Aluminium-4.jpg"}
{:id 14 :name "Silicon" :abb "Si" :img "https://upload.wikimedia.org/wikipedia/commons/e/e9/SiliconCroda.jpg"}
{:id 15 :name "Phosphorus" :abb "P" :img "https://upload.wikimedia.org/wikipedia/commons/8/88/PhosphComby.jpg"}
{:id 16 :name "Sulfur" :abb "S" :img "https://upload.wikimedia.org/wikipedia/commons/4/44/Sulfur-sample.jpg"}
{:id 17 :name "Chlorine" :abb "Cl" :img "https://upload.wikimedia.org/wikipedia/commons/f/f4/Chlorine_ampoule.jpg"}
{:id 18 :name "Argon" :abb "Ar" :img "https://upload.wikimedia.org/wikipedia/commons/8/87/Argon_discharge_tube.jpg"}
{:id 19 :name "Potassium" :abb "K" :img "https://upload.wikimedia.org/wikipedia/commons/a/a4/Potassium-2.jpg"}
{:id 20 :name "Calcium" :abb "Ca" :img "https://upload.wikimedia.org/wikipedia/commons/9/96/Calcium_unter_Argon_Schutzgasatmosph%C3%A4re.jpg"}
{:id 21 :name "Scandium" :abb "Sc" :img "https://upload.wikimedia.org/wikipedia/commons/e/e6/Scandium_sublimed_dendritic_and_1cm3_cube.jpg"}
{:id 22 :name "Titanium" :abb "Ti" :img "https://upload.wikimedia.org/wikipedia/commons/d/db/Titan-crystal_bar.JPG" :audio "https://upload.wikimedia.org/wikipedia/commons/a/a1/Titanium.ogg"}
{:id 23 :name "Vanadium" :abb "V" :img "https://upload.wikimedia.org/wikipedia/commons/9/98/Vanadium_etched.jpg"}
{:id 24 :name "Chromium" :abb "Cr" :img "https://upload.wikimedia.org/wikipedia/commons/0/08/Chromium_crystals_and_1cm3_cube.jpg"}
{:id 25 :name "Manganese" :abb "Mn" :img "https://upload.wikimedia.org/wikipedia/commons/8/86/Mangan_1-crop.jpg"}
{:id 26 :name "Iron" :abb "Fe" :img "https://upload.wikimedia.org/wikipedia/commons/a/ad/Iron_electrolytic_and_1cm3_cube.jpg"}
{:id 27 :name "Cobalt" :abb "Co" :img "https://upload.wikimedia.org/wikipedia/commons/a/a8/Kobalt_electrolytic_and_1cm3_cube.jpg"}
{:id 28 :name "Nickel" :abb "Ni" :img "https://upload.wikimedia.org/wikipedia/commons/5/57/Nickel_chunk.jpg"}
{:id 29 :name "Copper" :abb "Cu" :img "https://upload.wikimedia.org/wikipedia/commons/f/f0/NatCopper.jpg"}
{:id 30 :name "Zinc" :abb "Zn" :img "https://upload.wikimedia.org/wikipedia/commons/f/f9/Zinc_fragment_sublimed_and_1cm3_cube.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/6/6e/Zinc_spoken.ogg"}
{:id 31 :name "Gallium" :abb "Ga" :img "https://upload.wikimedia.org/wikipedia/commons/9/92/Gallium_crystals.jpg"}
{:id 32 :name "Germanium" :abb "Ge" :img "https://upload.wikimedia.org/wikipedia/commons/0/08/Polycrystalline-germanium.jpg"}
{:id 33 :name "Arsenic" :abb "As" :img "https://upload.wikimedia.org/wikipedia/commons/7/7b/Arsen_1a.jpg"}
{:id 34 :name "Selenium" :abb "Se" :img "https://upload.wikimedia.org/wikipedia/commons/4/47/SeBlackRed.jpg"}
{:id 35 :name "Bromine" :abb "Br" :img "https://upload.wikimedia.org/wikipedia/commons/b/bf/Bromine_25ml_%28transparent%29.png"}
{:id 36 :name "Krypton" :abb "Kr" :img "https://upload.wikimedia.org/wikipedia/commons/5/50/Krypton_discharge_tube.jpg"}
{:id 37 :name "Rubidium" :abb "Rb" :img "https://upload.wikimedia.org/wikipedia/commons/c/c9/Rb5.JPG"}
{:id 38 :name "Strontium" :abb "Sr" :img "https://upload.wikimedia.org/wikipedia/commons/4/41/Strontium_destilled_crystals.jpg"}
{:id 39 :name "Yttrium" :abb "Y" :img "https://upload.wikimedia.org/wikipedia/commons/1/19/Yttrium_sublimed_dendritic_and_1cm3_cube.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/8/8d/Yttrium_spoken.ogg"}
{:id 40 :name "Zirconium" :abb "Zr" :img "https://upload.wikimedia.org/wikipedia/commons/9/92/Zirconium_crystal_bar_and_1cm3_cube.jpg"}
{:id 41 :name "Niobium" :abb "Nb" :img "https://upload.wikimedia.org/wikipedia/commons/f/f2/Niobium_crystals_and_1cm3_cube.jpg"}
{:id 42 :name "Molybdenum" :abb "Mo" :img "https://upload.wikimedia.org/wikipedia/commons/3/32/Molybdenum_crystaline_fragment_and_1cm3_cube.jpg"}
{:id 43 :name "Technetium" :abb "Tc" :img "https://upload.wikimedia.org/wikipedia/en/8/89/Technetium.jpg"}
{:id 44 :name "Ruthenium" :abb "Ru" :img "https://upload.wikimedia.org/wikipedia/commons/2/2c/Ruthenium_a_half_bar.jpg"}
{:id 45 :name "Rhodium" :abb "Rh" :img "https://upload.wikimedia.org/wikipedia/commons/9/98/Rhodium_powder_pressed_melted.jpg"}
{:id 46 :name "Palladium" :abb "Pd" :img "https://upload.wikimedia.org/wikipedia/commons/d/d7/Palladium_%2846_Pd%29.jpg"}
{:id 47 :name "Silver" :abb "Ag" :img "https://upload.wikimedia.org/wikipedia/commons/5/55/Silver_crystal.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/0/0d/Silver.ogg"}
{:id 48 :name "Cadmium" :abb "Cd" :img "https://upload.wikimedia.org/wikipedia/commons/b/b5/Cadmium-crystal_bar.jpg"}
{:id 49 :name "Indium" :abb "In" :img "https://upload.wikimedia.org/wikipedia/commons/b/b8/Indium.jpg"}
{:id 50 :name "Tin" :abb "Sn" :img "https://upload.wikimedia.org/wikipedia/commons/2/2b/Sn-Alpha-Beta.jpg"}
{:id 51 :name "Antimony" :abb "Sb" :img "https://upload.wikimedia.org/wikipedia/commons/5/5c/Antimony-4.jpg"}
{:id 52 :name "Tellurium" :abb "Te" :img "https://upload.wikimedia.org/wikipedia/commons/c/c1/Tellurium2.jpg"}
{:id 53 :name "Iodine" :abb "I" :img "https://upload.wikimedia.org/wikipedia/commons/0/0a/Sample_of_iodine.jpg"}
{:id 54 :name "Xenon" :abb "Xe" :img "https://upload.wikimedia.org/wikipedia/commons/d/d7/Xenon_discharge_tube.jpg"}
{:id 55 :name "Caesium" :abb "Cs" :img "https://upload.wikimedia.org/wikipedia/commons/3/3d/Cesium.jpg" :audio "https://upload.wikimedia.org/wikipedia/commons/2/25/Caesium.ogg"}
{:id 56 :name "Barium" :abb "Ba" :img "https://upload.wikimedia.org/wikipedia/commons/1/16/Barium_unter_Argon_Schutzgas_Atmosph%C3%A4re.jpg"}
{:id 57 :name "Lanthanum" :abb "La" :img "https://upload.wikimedia.org/wikipedia/commons/8/8c/Lanthanum-2.jpg"}
{:id 58 :name "Cerium" :abb "Ce" :img "https://upload.wikimedia.org/wikipedia/commons/0/0d/Cerium2.jpg"}
{:id 59 :name "Praseodymium" :abb "Pr" :img "https://upload.wikimedia.org/wikipedia/commons/c/c7/Praseodymium.jpg"}
{:id 60 :name "Neodymium" :abb "Nd" :img "https://upload.wikimedia.org/wikipedia/commons/b/ba/Neodymium2.jpg"}
{:id 61 :name "Promethium" :abb "Pm" :img "http://userscontent2.emaze.com/images/00132bc5-9bb2-4d6b-876e-9eba04c0c840/5ef8a76c-8a7a-4247-ae7c-0a1a414834bd.JPG"}
{:id 62 :name "Samarium" :abb "Sm" :img "https://upload.wikimedia.org/wikipedia/commons/8/88/Samarium-2.jpg"}
{:id 63 :name "Europium" :abb "Eu" :img "https://upload.wikimedia.org/wikipedia/commons/6/6a/Europium.jpg"}
{:id 64 :name "Gadolinium" :abb "Gd" :img "https://upload.wikimedia.org/wikipedia/commons/d/d1/Gadolinium-4.jpg"}
{:id 65 :name "Terbium" :abb "Tb" :img "https://upload.wikimedia.org/wikipedia/commons/9/9a/Terbium-2.jpg"}
{:id 66 :name "Dysprosium" :abb "Dy" :img "https://upload.wikimedia.org/wikipedia/commons/a/a8/Dy_chips.jpg"}
{:id 67 :name "Holmium" :abb "Ho" :img "https://upload.wikimedia.org/wikipedia/commons/0/0a/Holmium2.jpg"}
{:id 68 :name "Erbium" :abb "Er" :img "https://upload.wikimedia.org/wikipedia/commons/1/12/Erbium-crop.jpg"}
{:id 69 :name "Thulium" :abb "Tm" :img "https://upload.wikimedia.org/wikipedia/commons/1/1e/Thulium_sublimed_dendritic_and_1cm3_cube.jpg"}
{:id 70 :name "Ytterbium" :abb "Yb" :img "https://upload.wikimedia.org/wikipedia/commons/c/ce/Ytterbium-3.jpg"}
{:id 71 :name "Lutetium" :abb "Lu" :img "https://upload.wikimedia.org/wikipedia/commons/7/74/Lutetium_sublimed_dendritic_and_1cm3_cube.jpg"}
{:id 72 :name "Hafnium" :abb "Hf" :img "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Hf-crystal_bar.jpg/1280px-Hf-crystal_bar.jpg"}
{:id 73 :name "Tantalum" :abb "Ta" :img "https://upload.wikimedia.org/wikipedia/commons/8/83/Tantalum_single_crystal_and_1cm3_cube.jpg"}
{:id 74 :name "Tungsten" :abb "W" :img "https://upload.wikimedia.org/wikipedia/commons/1/1a/Wolfram_evaporated_crystals_and_1cm3_cube.jpg"}
{:id 75 :name "Rhenium" :abb "Re" :img "https://upload.wikimedia.org/wikipedia/commons/7/71/Rhenium_single_crystal_bar_and_1cm3_cube.jpg"}
{:id 76 :name "Osmium" :abb "Os" :img "https://upload.wikimedia.org/wikipedia/commons/0/0c/Osmium_crystals.jpg"}
{:id 77 :name "Iridium" :abb "Ir" :img "https://upload.wikimedia.org/wikipedia/commons/a/a8/Iridium-2.jpg"}
{:id 78 :name "Platinum" :abb "Pt" :img "https://upload.wikimedia.org/wikipedia/commons/6/68/Platinum_crystals.jpg"}
{:id 79 :name "Gold" :abb "Au" :img "https://upload.wikimedia.org/wikipedia/commons/d/d7/Gold-crystals.jpg"}
{:id 80 :name "Mercury" :abb "Hg" :img "https://upload.wikimedia.org/wikipedia/commons/9/99/Pouring_liquid_mercury_bionerd.jpg"}
{:id 81 :name "Thallium" :abb "Tl" :img "https://upload.wikimedia.org/wikipedia/commons/b/bb/Thallium_pieces_in_ampoule.jpg"}
{:id 82 :name "Lead" :abb "Pb" :img "https://upload.wikimedia.org/wikipedia/commons/e/e6/Lead_electrolytic_and_1cm3_cube.jpg"}
{:id 83 :name "Bismuth" :abb "Bi" :img "https://upload.wikimedia.org/wikipedia/commons/e/ef/Bismuth_crystals_and_1cm3_cube.jpg"}
{:id 84 :name "Polonium" :abb "Po" :img "https://upload.wikimedia.org/wikipedia/en/6/66/Polonium.jpg"}
{:id 85 :name "Astatine" :abb "At" :img "http://www.chemistrylearner.com/wp-content/uploads/2018/03/Astatine.jpg"}
{:id 86 :name "Radon" :abb "Rn" :img "http://theodoregray.com/periodicTable/Samples/086.4/s12/35.JPG"}
{:id 87 :name "Francium" :abb "Fr" :img "http://www.chemistrylearner.com/wp-content/uploads/2018/02/Francium.jpg"}
{:id 88 :name "Radium" :abb "Ra" :img "https://upload.wikimedia.org/wikipedia/commons/b/bb/Radium226.jpg"}
{:id 89 :name "Actinium" :abb "Ac" :img "https://upload.wikimedia.org/wikipedia/en/f/f3/Actinium.jpg"}
{:id 90 :name "Thorium" :abb "Th" :img "https://upload.wikimedia.org/wikipedia/commons/1/13/Thorium_sample_0.1g.jpg"}
{:id 91 :name "Protactinium" :abb "Pa" :img "https://upload.wikimedia.org/wikipedia/en/0/05/Protactinium.jpg"}
{:id 92 :name "Uranium" :abb "U" :img "https://upload.wikimedia.org/wikipedia/commons/d/d8/HEUraniumC.jpg"}
{:id 93 :name "Neptunium" :abb "Np" :img "https://upload.wikimedia.org/wikipedia/commons/0/03/Np_sphere.jpg"}
{:id 94 :name "Plutonium" :abb "Pu" :img "https://upload.wikimedia.org/wikipedia/commons/9/98/Plutonium3.jpg"}
{:id 95 :name "Americium" :abb "Am" :img "https://upload.wikimedia.org/wikipedia/commons/e/ee/Americium_microscope.jpg"}
{:id 96 :name "Curium" :abb "Cm" :img "https://upload.wikimedia.org/wikipedia/en/6/69/Curium.jpg"}
{:id 97 :name "Berkelium" :abb "Bk" :img "https://upload.wikimedia.org/wikipedia/commons/b/b6/Berkelium_metal.jpg"}
{:id 98 :name "Californium" :abb "Cf" :img "https://upload.wikimedia.org/wikipedia/commons/9/93/Californium.jpg"}
{:id 99 :name "Einsteinium" :abb "Es" :img "https://upload.wikimedia.org/wikipedia/commons/5/55/Einsteinium.jpg"}
{:id 100 :name "Fermium" :abb "Fm" :img "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Fermium-Ytterbium_Alloy.jpg/220px-Fermium-Ytterbium_Alloy.jpg"}
{:id 101 :name "Mendelevium" :abb "Md" :img "http://images-of-elements.com/s/mendelevium.jpg"}
{:id 102 :name "Nobelium" :abb "No" :img "https://i.pinimg.com/originals/09/ea/ef/09eaef92cbae8f05b7ca506f4ae6feae.jpg"}
{:id 103 :name "Lawrencium" :abb "Lr" :img "http://www.chemistrylearner.com/wp-content/uploads/2018/03/Lawrencium.jpg"}
{:id 104 :name "Rutherfordium" :abb "Rf" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Rutherfordium-L.jpg?6.0.4.2"}
{:id 105 :name "Dubnium" :abb "Db" :img "https://s3.amazonaws.com/s3.timetoast.com/public/uploads/photos/4541101/download_%2832%29.jpg?1475075247"}
{:id 106 :name "Seaborgium" :abb "Sg" :img "http://www.chemistrylearner.com/wp-content/uploads/2018/01/Seaborgium.jpg"}
{:id 107 :name "Bohrium" :abb "Bh" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Bohrium-L.jpg?6.0.4.2"}
{:id 108 :name "Hassium" :abb "Hs" :img "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Molybdenit_1.jpg/220px-Molybdenit_1.jpg"}
{:id 109 :name "Meitnerium" :abb "Mt" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Meitnerium-L.jpg?6.0.4.2"}
{:id 110 :name "Darmstadtium" :abb "Ds" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Darmstadtium-L.jpg?6.0.4.2"}
{:id 111 :name "Roentgenium" :abb "Rg" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Roentgenium-L.jpg?6.0.4.2"}
{:id 112 :name "Copernicium" :abb "Cn" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Copernicium-L.jpg?6.0.4.2"}
{:id 113 :name "Nihonium" :abb "Nh" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Nihonium-L.jpg?6.0.4.2"}
{:id 114 :name "Flerovium" :abb "Fl" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Flerovium-L.jpg?6.0.4.2"}
{:id 115 :name "Moscovium" :abb "Mc" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Moscovium-L.jpg?6.0.4.2"}
{:id 116 :name "Livermorium" :abb "Lv" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Livermorium-L.jpg?6.0.4.2"}
{:id 117 :name "Tennessine" :abb "Ts" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Tennessine-L.jpg?6.0.4.2"}
{:id 118 :name "Ununoctium" :abb "Og" :img "http://sod-a.rsc-cdn.org/www.rsc.org/periodic-table/content/Images/Elements/Oganesson-L.jpg?6.0.4.2"}])

(def click-count (atom 1))

(defn buttons []
  [:div
   [:input {:type "button" :value "Previous"
            :on-click #(swap! click-count dec)}]
   [:input {:type "button" :value "Next"
            :on-click #(swap! click-count inc)}]])

(defn tictactoe []
  [:center
   [:h1 (:text @app-state)]
    [:h1 @click-count]
    [:h1 (:abb (elements (dec @click-count)))]
    [:h2 (:name (elements (dec @click-count)))]
    [:audio {:controls true :src (str "http://www.rsc.org/periodic-table/content/podcasts/" (:name (elements (dec @click-count))) ".mp3?6.0.4.2")}]
    [buttons]
    [:img
 {:src (:img (elements (dec @click-count))) :height 400}]
    [:iframe {:src (str "https://en.wikipedia.org/wiki/" (:name (elements (dec @click-count)))) :width "1200" :height "600"}]])

(reagent/render-component [tictactoe]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  (prn (:board @app-state)))
