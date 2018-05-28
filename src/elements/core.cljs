(ns elements.core
   (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defn new-board [n]
  (vec (repeat n (vec (repeat n "B")))))

(def board-size 1)

(defonce app-state
  (atom {:text "The Chemical Elements"
         :board (new-board board-size)}))

(def elements
[{:id 1 :name "Hydrogen" :abb "H"}
{:id 2 :name "Helium" :abb "He"}
{:id 3 :name "Lithium" :abb "Li"}
{:id 4 :name "Beryllium" :abb "Be"}
{:id 5 :name "Boron" :abb "B"}
{:id 6 :name "Carbon" :abb "C"}
{:id 7 :name "Nitrogen" :abb "N"}
{:id 8 :name "Oxygen" :abb "O"}
{:id 9 :name "Fluorine" :abb "F"}
{:id 10 :name "Neon" :abb "Ne"}
{:id 11 :name "Sodium" :abb "Na"}
{:id 12 :name "Magnesium" :abb "Mg"}
{:id 13 :name "Aluminum" :abb "Al"}
{:id 14 :name "Silicon" :abb "Si"}
{:id 15 :name "Phosphorus" :abb "P"}
{:id 16 :name "Sulfur" :abb "S"}
{:id 17 :name "Chlorine" :abb "Cl"}
{:id 18 :name "Argon" :abb "Ar"}
{:id 19 :name "Potassium" :abb "K"}
{:id 20 :name "Calcium" :abb "Ca"}
{:id 21 :name "Scandium" :abb "Sc"}
{:id 22 :name "Titanium" :abb "Ti"}
{:id 23 :name "Vanadium" :abb "V"}
{:id 24 :name "Chromium" :abb "Cr"}
{:id 25 :name "Manganese" :abb "Mn"}
{:id 26 :name "Iron" :abb "Fe"}
{:id 27 :name "Cobalt" :abb "Co"}
{:id 28 :name "Nickel" :abb "Ni"}
{:id 29 :name "Copper" :abb "Cu"}
{:id 30 :name "Zinc" :abb "Zn"}
{:id 31 :name "Gallium" :abb "Ga"}
{:id 32 :name "Germanium" :abb "Ge"}
{:id 33 :name "Arsenic" :abb "As"}
{:id 34 :name "Selenium" :abb "Se"}
{:id 35 :name "Bromine" :abb "Br"}
{:id 36 :name "Krypton" :abb "Kr"}
{:id 37 :name "Rubidium" :abb "Rb"}
{:id 38 :name "Strontium" :abb "Sr"}
{:id 39 :name "Yttrium" :abb "Y"}
{:id 40 :name "Zirconium" :abb "Zr"}
{:id 41 :name "Niobium" :abb "Nb"}
{:id 42 :name "Molybdenum" :abb "Mo"}
{:id 43 :name "Technetium" :abb "Tc"}
{:id 44 :name "Ruthenium" :abb "Ru"}
{:id 45 :name "Rhodium" :abb "Rh"}
{:id 46 :name "Palladium" :abb "Pd"}
{:id 47 :name "Silver" :abb "Ag"}
{:id 48 :name "Cadmium" :abb "Cd"}
{:id 49 :name "Indium" :abb "In"}
{:id 50 :name "Tin" :abb "Sn"}
{:id 51 :name "Antimony" :abb "Sb"}
{:id 52 :name "Tellurium" :abb "Te"}
{:id 53 :name "Iodine" :abb "I"}
{:id 54 :name "Xenon" :abb "Xe"}
{:id 55 :name "Cesium" :abb "Cs"}
{:id 56 :name "Barium" :abb "Ba"}
{:id 57 :name "Lanthanum" :abb "La"}
{:id 58 :name "Cerium" :abb "Ce"}
{:id 59 :name "Praseodymium" :abb "Pr"}
{:id 60 :name "Neodymium" :abb "Nd"}
{:id 61 :name "Promethium" :abb "Pm"}
{:id 62 :name "Samarium" :abb "Sm"}
{:id 63 :name "Europium" :abb "Eu"}
{:id 64 :name "Gadolinium" :abb "Gd"}
{:id 65 :name "Terbium" :abb "Tb"}
{:id 66 :name "Dysprosium" :abb "Dy"}
{:id 67 :name "Holmium" :abb "Ho"}
{:id 68 :name "Erbium" :abb "Er"}
{:id 69 :name "Thulium" :abb "Tm"}
{:id 70 :name "Ytterbium" :abb "Yb"}
{:id 71 :name "Lutetium" :abb "Lu"}
{:id 72 :name "Hafnium" :abb "Hf"}
{:id 73 :name "Tantalum" :abb "Ta"}
{:id 74 :name "Tungsten" :abb "W"}
{:id 75 :name "Rhenium" :abb "Re"}
{:id 76 :name "Osmium" :abb "Os"}
{:id 77 :name "Iridium" :abb "Ir"}
{:id 78 :name "Platinum" :abb "Pt"}
{:id 79 :name "Gold" :abb "Au"}
{:id 80 :name "Mercury" :abb "Hg"}
{:id 81 :name "Thallium" :abb "Tl"}
{:id 82 :name "Lead" :abb "Pb"}
{:id 83 :name "Bismuth" :abb "Bi"}
{:id 84 :name "Polonium" :abb "Po"}
{:id 85 :name "Astatine" :abb "At"}
{:id 86 :name "Radon" :abb "Rn"}
{:id 87 :name "Francium" :abb "Fr"}
{:id 88 :name "Radium" :abb "Ra"}
{:id 89 :name "Actinium" :abb "Ac"}
{:id 90 :name "Thorium" :abb "Th"}
{:id 91 :name "Protactinium" :abb "Pa"}
{:id 92 :name "Uranium" :abb "U"}
{:id 93 :name "Neptunium" :abb "Np"}
{:id 94 :name "Plutonium" :abb "Pu"}
{:id 95 :name "Americium" :abb "Am"}
{:id 96 :name "Curium" :abb "Cm"}
{:id 97 :name "Berkelium" :abb "Bk"}
{:id 98 :name "Californium" :abb "Cf"}
{:id 99 :name "Einsteinium" :abb "Es"}
{:id 100 :name "Fermium" :abb "Fm"}
{:id 101 :name "Mendelevium" :abb "Md"}
{:id 102 :name "Nobelium" :abb "No"}
{:id 103 :name "Lawrencium" :abb "Lr"}
{:id 104 :name "Rutherfordium" :abb "Rf"}
{:id 105 :name "Dubnium" :abb "Db"}
{:id 106 :name "Seaborgium" :abb "Sg"}
{:id 107 :name "Bohrium" :abb "Bh"}
{:id 108 :name "Hassium" :abb "Hs"}
{:id 109 :name "Meitnerium" :abb "Mt"}])

(def click-count (reagent/atom 1))

(defn buttons []
  [:div
   [:input {:type "button" :value "Down"
            :on-click #(swap! click-count dec)}]
   [:input {:type "button" :value "Up"
            :on-click #(swap! click-count inc)}]])

(defn tictactoe []
  [:center
   [:h1 (:text @app-state)]
    [:h1 @click-count]
    [:h1 (:abb (elements (dec @click-count)))]
    [:h2 (:name (elements (dec @click-count)))]
    [buttons]])

(reagent/render-component [tictactoe]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  (prn (:board @app-state)))
