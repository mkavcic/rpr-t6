package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import org.apache.commons.validator.routines.EmailValidator;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationMessage;
import org.controlsfx.validation.decoration.GraphicValidationDecoration;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;

import static java.lang.Character.getNumericValue;

public class Controller {
    private SmjerModel model2;
    private MjestoRodjenjaModel model1;
    private CiklusModel model3;
    private GodinaModel model4;
    private StatusModel model5;
    public ChoiceBox<Ciklus> izborCiklusa;
    public ComboBox<MjestoRodjenja> izborMjesta;
    public ChoiceBox<Smjer> izborSmjera;
    public ChoiceBox<Godina> izborGodine;
    public ChoiceBox<Status> izborStatusa;

    public TextField ime;
    public TextField prezime;
    public TextField indeks;
    public TextField jmbg;

    public DatePicker datum;

    public TextField adresa;
    public TextField telefon;
    public TextField email;


    public Controller(MjestoRodjenjaModel model, SmjerModel model3, CiklusModel ciklusModel, GodinaModel godinaModel, StatusModel statusModel) {
        this.model1 = model;
        this.model2 = model3;
        this.model3=ciklusModel;
        this.model4=godinaModel;
        this.model5=statusModel;
    }

    private boolean validnoImePrezime(String n){
        if(n==null) return false;
        if(n.length()<2 || n.length()>20) return false;
        for(int i=0; i<n.length(); i++){
            if((n.charAt(i)<'A' || n.charAt(i)>'Ž') && (n.charAt(i)<'a' || n.charAt(i)>'ž')) return false;
        }
        return true;
    }

    private boolean validanIndeks(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (!(n.charAt(i) >= '0' && n.charAt(i) <= '9') || n==null || n.charAt(0) == '0') return false;
        }
        if(n.length() != 5) return false;
        return true;
    }

    private boolean validanJmbg(String n) {
        if (n == null || n.length() != 13) return false;
        int a = getNumericValue(n.charAt(5)) * 10 + getNumericValue(n.charAt(6));
        int b=getNumericValue(n.charAt(2)) * 10 + getNumericValue(n.charAt(3));
        if (n.charAt(2) == 0 && n.charAt(3) == 2 && a % 4 == 0) {
            if (n.charAt(0) > 2) return false;
        } else if (n.charAt(2) == 0 && n.charAt(3) == 2 && a % 4 != 0) {
            if (n.charAt(0) > 2 && n.charAt(1) > 8) return false;
        } else if (b>12)return false;
        else if (n.charAt(4) == 0) {
            if (a > 18) return false;
        }
        int L = 11 - (( 7*(getNumericValue(n.charAt(0))+getNumericValue(n.charAt(6))) + 6*(getNumericValue(n.charAt(1))+getNumericValue(n.charAt(7))) + 5*(getNumericValue(n.charAt(2))+getNumericValue(n.charAt(8))) + 4*(getNumericValue(n.charAt(3))+getNumericValue(n.charAt(9))) + 3*(getNumericValue(n.charAt(4))+getNumericValue(n.charAt(10))) + 2*(getNumericValue(n.charAt(5))+getNumericValue(n.charAt(11))) ) % 11);
        if(L>9) L=0;
        if(getNumericValue(n.charAt(12))!=L) return false;
        return true;
    }

    private boolean validanDatum(LocalDate datum1) {
        Date date = new Date();
        if (jmbg.getCharacters().toString().isEmpty()) {
            return false;
        }
        if (date.getYear() < datum1.getYear() && date.getMonth() < datum1.getMonth().getValue() && date.getDay() < datum1.getDayOfYear()) {
            return false;
        } else {
            if (Integer.parseInt(jmbg.getCharacters().toString().substring(4, 7)) < 900) {
                if (datum1.getYear() != Integer.parseInt("2" + jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            } else {
                if (datum1.getYear() != Integer.parseInt("1" + jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            }
            if (datum1.getMonth().getValue() != Integer.parseInt(jmbg.getCharacters().toString().substring(2, 4).replace("0", ""))) {
                return false;
            } else if (datum1.getDayOfYear() != Integer.parseInt(jmbg.getCharacters().toString().substring(0, 2).replace("0", ""))) {
                return false;
            } else {
                return true;
            }
        }
    }

    private boolean validanTelefon(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void initialize(){
        izborMjesta.setItems(model1.getMjesta());
        izborSmjera.setItems(model2.getSmjerovi());
        izborCiklusa.setItems(model3.getCiklusi());
        izborGodine.setItems(model4.getGodine());
        izborStatusa.setItems(model5.getStatusi());

        ime.getStyleClass().add("poljeNijeIspravno");
        prezime.getStyleClass().add("poljeNijeIspravno");
        indeks.getStyleClass().add("poljeNijeIspravno");
        jmbg.getStyleClass().add("poljeNijeIspravno");
        adresa.getStyleClass().add("poljeIspravno");
        telefon.getStyleClass().add("poljeIspravno");
        email.getStyleClass().add("poljeNijeIspravno");

        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        ime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validnoImePrezime(ime.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, smije sadržavati samo slova, maksimalno 20";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return ime;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(ime);
                }
            }
        });

        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        prezime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validnoImePrezime(prezime.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, smije sadržavati samo slova, maksimalno 20";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return prezime;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(prezime);
                }
            }
        });

        indeks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indeks.getStyleClass().removeAll("poljeNijeIspravno");
                    indeks.getStyleClass().add("poljeIspravno");
                } else {
                    indeks.getStyleClass().removeAll("poljeIspravno");
                    indeks.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        indeks.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanIndeks(indeks.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, mora sadržavati petocifreni broj";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return indeks;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(indeks);
                }
            }
        });

        jmbg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanJmbg(n)) {
                    jmbg.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbg.getStyleClass().add("poljeIspravno");
                }
                else {
                    jmbg.getStyleClass().removeAll("poljeIspravno");
                    jmbg.getStyleClass().add("poljeNijeIspravno");

                }
            }
        });

        jmbg.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanJmbg(jmbg.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Provjerite jeste li ispravno unijeli JMBG";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return jmbg;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(jmbg);
                }
            }
        });

        datum.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean o, Boolean n) {

                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanDatum(datum.getValue())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite datum u skladu s vašim JMBG-om!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return datum;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(datum);
                }
            }
        });

        telefon.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanTelefon(telefon.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Broj telefona mora sadržiti iskljčivo cifre u sebi!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return telefon;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(telefon);
                }
            }
        });

        telefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanTelefon(n)) {
                    telefon.getStyleClass().removeAll("poljeNijeIspravno");
                    telefon.getStyleClass().add("poljeIspravno");
                } else {
                    telefon.getStyleClass().removeAll("poljeIspravno");
                    telefon.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    email.getStyleClass().removeAll("poljeNijeIspravno");
                    email.getStyleClass().add("poljeIspravno");
                } else {
                    email.getStyleClass().removeAll("poljeIspravno");
                    email.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        email.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                EmailValidator validator = EmailValidator.getInstance();
                if (!n && !validator.isValid(email.getText())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Neispravna email adresa";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return email;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(email);
                }
            }
        });

    }

}


