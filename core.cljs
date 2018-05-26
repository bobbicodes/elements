(ns reagent-tutorial.core
  (:require [clojure.string :as string]
            [reagent.core :as r]))

(enable-console-print!)

(def app-state
  (r/atom
   {:elements
[{:id 1 :name "Hydrogen"}
{:id 2 :name "Helium"}
{:id 3 :name "Lithium"}
{:id 4 :name "Beryllium"}
{:id 5 :name "Boron"}
{:id 6 :name "Carbon"}
{:id 7 :name "Nitrogen"}
{:id 8 :name "Oxygen"}
{:id 9 :name "Fluorine"}
{:id 10 :name "Neon"}
{:id 11 :name "Sodium"}
{:id 12 :name "Magnesium"}
{:id 13 :name "Aluminum"}
{:id 14 :name "Silicon"}
{:id 15 :name "Phosphorus"}
{:id 16 :name "Sulfur"}
{:id 17 :name "Chlorine"}
{:id 18 :name "Argon"}
{:id 19 :name "Potassium"}
{:id 20 :name "Calcium"}
{:id 21 :name "Scandium"}
{:id 22 :name "Titanium"}
{:id 23 :name "Vanadium"}
{:id 24 :name "Chromium"}
{:id 25 :name "Manganese"}
{:id 26 :name "Iron"}
{:id 27 :name "Cobalt"}
{:id 28 :name "Nickel"}
{:id 29 :name "Copper"}
{:id 30 :name "Zinc"}
{:id 31 :name "Gallium"}
{:id 32 :name "Germanium"}
{:id 33 :name "Arsenic"}
{:id 34 :name "Selenium"}
{:id 35 :name "Bromine"}
{:id 36 :name "Krypton"}
{:id 37 :name "Rubidium"}
{:id 38 :name "Strontium"}
{:id 39 :name "Yttrium"}
{:id 40 :name "Zirconium"}
{:id 41 :name "Niobium"}
{:id 42 :name "Molybdenum"}
{:id 43 :name "Technetium"}
{:id 44 :name "Ruthenium"}
{:id 45 :name "Rhodium"}
{:id 46 :name "Palladium"}
{:id 47 :name "Silver"}
{:id 48 :name "Cadmium"}
{:id 49 :name "Indium"}
{:id 50 :name "Tin"}
{:id 51 :name "Antimony"}
{:id 52 :name "Tellurium"}
{:id 53 :name "Iodine"}
{:id 54 :name "Xenon"}
{:id 55 :name "Cesium"}
{:id 56 :name "Barium"}
{:id 57 :name "Lanthanum"}
{:id 58 :name "Cerium"}
{:id 59 :name "Praseodymium"}
{:id 60 :name "Neodymium"}
{:id 61 :name "Promethium"}
{:id 62 :name "Samarium"}
{:id 63 :name "Europium"}
{:id 64 :name "Gadolinium"}
{:id 65 :name "Terbium"}
{:id 66 :name "Dysprosium"}
{:id 67 :name "Holmium"}
{:id 68 :name "Erbium"}
{:id 69 :name "Thulium"}
{:id 70 :name "Ytterbium"}
{:id 71 :name "Lutetium"}
{:id 72 :name "Hafnium"}
{:id 73 :name "Tantalum"}
{:id 74 :name "Tungsten"}
{:id 75 :name "Rhenium"}
{:id 76 :name "Osmium"}
{:id 77 :name "Iridium"}
{:id 78 :name "Platinum"}
{:id 79 :name "Gold"}
{:id 80 :name "Mercury"}
{:id 81 :name "Thallium"}
{:id 82 :name "Lead"}
{:id 83 :name "Bismuth"}
{:id 84 :name "Polonium"}
{:id 85 :name "Astatine"}
{:id 86 :name "Radon"}
{:id 87 :name "Francium"}
{:id 88 :name "Radium"}
{:id 89 :name "Actinium"}
{:id 90 :name "Thorium"}
{:id 91 :name "Protactinium"}
{:id 92 :name "Uranium"}
{:id 93 :name "Neptunium"}
{:id 94 :name "Plutonium"}
{:id 95 :name "Americium"}
{:id 96 :name "Curium"}
{:id 97 :name "Berkelium"}
{:id 98 :name "Californium"}
{:id 99 :name "Einsteinium"}
{:id 100 :name "Fermium"}
{:id 101 :name "Mendelevium"}
{:id 102 :name "Nobelium"}
{:id 103 :name "Lawrencium"}
{:id 104 :name "Rutherfordium"}
{:id 105 :name "Dubnium"}
{:id 106 :name "Seaborgium"}
{:id 107 :name "Bohrium"}
{:id 108 :name "Hassium"}
{:id 109 :name "Meitnerium"}]}))

(defn display-element [{:keys [id name] :as element}]
  (str id " " name))

(defn element [c]
[:li
   [:span (display-element c)]])

(defn element-list []
  [:div
   [:h1 "Elements"]
   [:ul
    (for [c (:elements @app-state)]
      [element c])]])

;; Render the root component
(defn start []
  (r/render-component 
   [element-list]
   (.getElementById js/document "root")))
