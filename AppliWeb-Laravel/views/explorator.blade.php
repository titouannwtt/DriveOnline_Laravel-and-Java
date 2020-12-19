
            <div class="Explorator">
                <h3>Explorateur</h3>
                <div class="E_Folder">
                        @php
                            if(isset($_GET['directory'])){
                                $baseurl="/srv/http/Drive/storage/app/public/";
                            }else{
                                $baseurl="/srv/http/Drive/storage/app/public";
                            }
                            if("$_SERVER[REQUEST_URI]" == "/"){
                                $path=$baseurl;
                            }else{
                                $path=$baseurl.$_GET['directory'];
                            }
                            $current_link = 'http://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
                            try{
                                foreach (new DirectoryIterator($path) as $fileInfo) {
                                    if($fileInfo->isDot()) continue;
                                    if(is_dir($path."/".$fileInfo->getFilename())){
                                        echo '<img src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-1/256/folder-icon.png">'.$fileInfo->getFilename().'<br>';
                                    }else{
                                        echo '<div class="E_File"><img src="https://cdn3.iconfinder.com/data/icons/brands-applications/512/File-512.png">'.$fileInfo->getFilename().'</div>';
                                    }
                                }
                            }catch (Exception $hi){
                                echo "<h3><i class='fas fa-exclamation-triangle'></i>Nothing to print<i class='fas fa-exclamation-triangle'></i></h3>";
                            }
                        @endphp
                    <!-- Changer l'image si fichier php,txt,java ou autre -->
                </div>
                <!-- SI CONNECTÉ -->
                <div class="E_GroupList">
                    <h3>Vos groupes :</h3>
                    <a href="/groups" ><div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Groupe1</div></a>
                    <div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Groupe2</div>
                    <div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Groupe3</div>
                    <h3>Vos cercles :</h3>
                    <div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Cercle1</div>
                    <div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Cercle2</div>
                    <div class="E_Group"><img src="https://c8.alamy.com/compfr/kk5kjc/iage-icone-des-kk5kjc.jpg">Cercle3</div>
                </div>
            </div>