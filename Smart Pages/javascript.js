 


        
        // Intialize created menu section
        function startUp() {
            var dieter = prompt("Please enter your name:");
            
            if (dieter == null) {
                dieter = "Guest";
            }
            var date = new Date();
            
            var createdMenuDetails1 = document.createTextNode("Personalized menu for " + dieter);
            var createdMenuDetails2 = document.createTextNode(" (Created on " + date.getMonth() + "/" + date.getDate() + "/" + date.getYear() + ")");
            var createdMenuDetails3 = document.createTextNode;
            
            var newNode = document.getElementById('createdMenu');
            newNode.appendChild(createdMenuDetails1);
            newNode.appendChild(createdMenuDetails2);

        }
        

        // Show/hide expanded list items
        function visToggle(list) {
            var currentState = document.getElementById(list).style.display;
            if (currentState == "none"){
                document.getElementById(list).style.display = "inline";
            } else {
                document.getElementById(list).style.display = "none";
            }    
        }
            
            
        // Menu builder & Selection handeling 
            
        var proteinSelection;
        var proteinComplete = false;
            
        var unlimitedVegSelection;
        var unlimitedVegComplete = false;
            
        var selectVegSelection;
        var selectComplete = false;
            
        var occasionalVegSelection;
        var occasionalVegComplete = false; 
        
        var seasoningSelection;
        var seasoningComplete = false; 
            
        function select(id) {
            
            var item = document.getElementById(id);

            var selectedItem = document.getElementById(id).lastChild;
            var cloneSelection = selectedItem.cloneNode(true);
            
            if (item.classList.contains('free')) {
                
                if (id < 200) {
                       
                        if (proteinComplete == false) {
                        item.classList.remove("free");
                        item.classList.add("selected");

                        var proteinItem = document.getElementById("proteinMenu");
                        proteinItem.appendChild(cloneSelection);
                        proteinComplete = true;
                    
                    } else if (proteinComplete == true) {
                    
                        var proteinItem = document.getElementById("proteinMenu");

                        var prevSelection =  proteinItem.lastChild;
                    
                            if (confirm("Do you want to replace " + prevSelection.nodeValue + " in your menu with " + selectedItem.nodeValue + "?")) {
                               clearSelections('dinnerProtein');

                                item.classList.remove("free");
                                item.classList.add("selected");
                                proteinItem.removeChild(proteinItem.childNodes[1]);
                                proteinItem.appendChild(cloneSelection); 
                            } // end of confirmation conditional 
        
                        }  // End of delselect unlimited veg section
                        
                 } else if (id < 300) {
                     
                     if (unlimitedVegComplete  == false) {
                        item.classList.remove("free");
                        item.classList.add("selected");

                        var uVegItem = document.getElementById("uVegMenu");
                        uVegItem.appendChild(cloneSelection);
                        unlimitedVegComplete = true;
                    
                     } else if (unlimitedVegComplete == true) {
                    
                        var uVegItem = document.getElementById("uVegMenu");

                        var prevSelection =  uVegItem.lastChild;
                    
                            if (confirm("Do you want to replace " + prevSelection.nodeValue + " in your menu with " + selectedItem.nodeValue + "?")) {
                               clearSelections('unlimitedRawVeg');

                                item.classList.remove("free");
                                item.classList.add("selected");
                                uVegItem.removeChild(uVegItem.childNodes[1]);
                                uVegItem.appendChild(cloneSelection); 
                            } // end of confirmation conditional 
        
                        }  // End of delselect unlimited veg section
                     
                 } else if (id < 400) {
                     
                     if (selectComplete == false) {
                        item.classList.remove("free");
                        item.classList.add("selected");

                        var sVegItem = document.getElementById("sVegMenu");
                        sVegItem.appendChild(cloneSelection);
                        selectComplete = true;
                    
                     } else if (selectComplete == true) {
                    
                        var sVegItem = document.getElementById("sVegMenu");

                        var prevSelection =  sVegItem.lastChild;
                     
                            if (confirm("Do you want to replace " + prevSelection.nodeValue + " in your menu with " + selectedItem.nodeValue + "?")) {
                               clearSelections('selectVeg');

                                item.classList.remove("free");
                                item.classList.add("selected");
                                sVegItem.removeChild(sVegItem.childNodes[1]);
                                sVegItem.appendChild(cloneSelection); 
                            } // end of confirmation conditional 
        
                        }  // End of delselect select veg section
                     
                 } else if (id < 500) {
                     
                    if (occasionalVegComplete  == false) {
                        item.classList.remove("free");
                        item.classList.add("selected");

                        var oVegItem = document.getElementById("oVegMenu");
                        oVegItem.appendChild(cloneSelection);
                        occasionalVegComplete  = true;
                    
                     } else if (occasionalVegComplete  == true) {
                    
                        var oVegItem = document.getElementById("oVegMenu");

                        var prevSelection =  oVegItem.lastChild;
                     
                            if (confirm("Do you want to replace " + prevSelection.nodeValue + " in your menu with " + selectedItem.nodeValue + "?")) {
                               clearSelections('occasionalVeg');

                                item.classList.remove("free");
                                item.classList.add("selected");
                                oVegItem.removeChild(oVegItem.childNodes[1]);
                                oVegItem.appendChild(cloneSelection); 
                            } // end of confirmation conditional 
        
                        }  // End of delselect select veg section
                     
                 } else {
                    
                    if (seasoningComplete == false) {
                        item.classList.remove("free");
                        item.classList.add("selected");

                        var seasonItem = document.getElementById("seasonMenu");
                        seasonItem.appendChild(cloneSelection);
                        seasoningComplete  = true;
                    
                     } else if (seasoningComplete  == true) {
                    
                        var seasonItem = document.getElementById("seasonMenu");

                        var prevSelection =  seasonItem.lastChild;
                     
                            if (confirm("Do you want to replace " + prevSelection.nodeValue + " in your menu with " + selectedItem.nodeValue + "?")) {
                               clearSelections('seasonings');

                                item.classList.remove("free");
                                item.classList.add("selected");
                                seasonItem.removeChild(seasonItem.childNodes[1]);
                                seasonItem.appendChild(cloneSelection); 
                            } // end of confirmation conditional 
        
                        }  // End of delselect select veg section 
                     
                 }

                    
  
            } else if (item.classList.contains('selected')){
                
                if (id < 200) {
                    if (proteinComplete == true) {  
                   var proteinItem = document.getElementById("proteinMenu");
                    
                   var prevSelection =  proteinItem.lastChild;
                    
                    
                    if (confirm("Do you want to remove " + selectedItem.nodeValue + " from your menu?")){
                        item.classList.remove("selected");
                        item.classList.add("free");
                        proteinItem.removeChild(proteinItem.childNodes[1]);
                        proteinComplete = false;
                    } // end of confrimation conditional

                    }  // end of new protein selection management
            
                } else if (id < 300) {
                    if (unlimitedVegComplete  == true) {  
                           var uVegItem = document.getElementById("uVegMenu");

                           var prevSelection =  uVegItem.lastChild;


                            if (confirm("Do you want to remove " + selectedItem.nodeValue + " from your menu?")){
                                item.classList.remove("selected");
                                item.classList.add("free");
                                uVegItem.removeChild(uVegItem.childNodes[1]);
                                unlimitedVegComplete  = false;
                            } // end of confrimation conditional

                        }  // end of new unlimited veggie selection management
                    
                } else if (id < 400) {
                     
                    if (selectComplete  == true) {  
                           var sVegItem = document.getElementById("sVegMenu");

                           var prevSelection =  sVegItem.lastChild;


                            if (confirm("Do you want to remove " + selectedItem.nodeValue + " from your menu?")){
                                item.classList.remove("selected");
                                item.classList.add("free");
                                sVegItem.removeChild(sVegItem.childNodes[1]);
                                selectComplete = false;
                            } // end of confrimation conditional

                        }  // end of new select veggie selection management
                    
                 } else if (id < 500) {
                     
                        if (occasionalVegComplete == true) {  
                           var oVegItem = document.getElementById("oVegMenu");

                           var prevSelection =  oVegItem.lastChild;


                            if (confirm("Do you want to remove " + selectedItem.nodeValue + " from your menu?")){
                                item.classList.remove("selected");
                                item.classList.add("free");
                                oVegItem.removeChild(oVegItem.childNodes[1]);
                                occasionalVegComplete = false;
                            } // end of confrimation conditional

                        }  // end of new select veggie selection management
                     
                 } else {
                     
                     if (seasoningComplete == true) {  
                           var seasonItem = document.getElementById("seasonMenu");

                           var prevSelection =  seasonItem.lastChild;


                            if (confirm("Do you want to remove " + selectedItem.nodeValue + " from your menu?")){
                                item.classList.remove("selected");
                                item.classList.add("free");
                                seasonItem.removeChild(seasonItem.childNodes[1]);
                                seasoningComplete = false;
                            } // end of confrimation conditional

                        }  // end of new select veggie selection management
                     
                 }
    
            }
        } // End of select function
            
            
            
            function clearSelections(section) {
                var currentSection = document.getElementById(section);
                var list = currentSection.getElementsByClassName("selected");

                while (list.length > 0) {
                    list[0].classList.add("free");
                    list[0].classList.remove("selected");
                    
                } // End of while loop
                
            } // End of clear Selection function


            // Prompt user to enter name on page load
            window.onload = startUp;


            /* Refrences and code sources
            
            Ideas on how to handle deselecting items comes from:
            
            https://stackoverflow.com/questions/22270664/remove-class-from-elements-in-pure-javascript

             https://stackoverflow.com/questions/26362423/how-to-remove-a-specific-class-from-all-elements
             
             
             For style help, background image info was found at:
             https://www.w3schools.com/css/css_background.asp
            
            */