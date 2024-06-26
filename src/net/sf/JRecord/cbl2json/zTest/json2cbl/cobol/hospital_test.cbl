        01  HOSPITAL.
          03  HOSPNAME        PIC X(20).
          03  HOSP-ADDRESS      PIC X(30).
          03  HOSP-PHONE        PIC X(10).
          03  ADMIN         PIC X(20).

        01  WARD.
          03  WARDNO          PIC XX.
          03  TOT-ROOMS       PIC XXX.
          03  TOT-BEDS        PIC XXX.
          03  BEDAVAIL        PIC XXX.
          03  WARDTYPE        PIC X(20).

        01  PATIENT.
          03  PATNAME         PIC X(20).
          03  PATADDRESS        PIC X(30).
          03  PAT-PHONE       PIC X(10).
          03  BEDIDENT        PIC X(4).
          03  DATEADMT        PIC X(6).
          03  PREV-STAY-FLAG      PIC X.
          03  PREV-HOSP       PIC X(20).
          03  PREV-DATE       PIC X(4).
          03  PREV-REASON       PIC X(30).

        01  SYMPTOM.
          03  DIAGNOSE        PIC X(20).
          03  SYMPDATE        PIC X(6).
          03  PREV-TREAT-FLAG     PIC X.
          03  TREAT-DESC        PIC X(20).
          03  SYMP-DOCTOR       PIC X(20).
          03  SYMP-DOCT-PHONE     PIC X(10).

        01  TREATMNT.
          03  TRTYPE          PIC X(20).
          03  TRDATE          PIC X(6).
          03  MEDICATION-TYPE     PIC X(20).
          03  DIET-COMMENT      PIC X(30).
          03  SURGERY-FLAG      PIC X.
          03  SURGERY-DATE      PIC X(6).
          03  SURGERY-COMMENT     PIC X(30).

        01  DOCTOR.
          03  DOCTNAME        PIC X(20).
          03  DOCT-ADDRESS      PIC X(30).
          03  DOCT-PHONE        PIC X(10).
          03  SPECIALT        PIC X(20).

        01  FACILITY.
          03  FACTYPE         PIC X(20).
          03  TOT-FACIL       PIC XXX.
          03  FACAVAIL        PIC XXX.