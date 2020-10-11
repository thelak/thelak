package com.thelak.payments.services;

import com.thelak.database.entity.DbCertificate;
import com.thelak.database.entity.DbOptionCertificate;
import com.thelak.database.entity.DbOptionSubscription;
import com.thelak.database.entity.DbSubscription;
import com.thelak.route.payments.models.certificate.CertificateModel;
import com.thelak.route.payments.models.subscription.SubscriptionModel;
import com.thelak.route.video.models.VideoModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaymentsHelper {

    public static SubscriptionModel buildSubscriptionModel(DbSubscription dbSubscription) {
        List<String> list = new ArrayList<>();
        List<DbOptionSubscription> dbOptionSubscriptions = dbSubscription.getSubscriptionToOpsub();
        dbOptionSubscriptions.forEach(dbOptionSubscription -> {
            list.add(dbOptionSubscription.getOpsubToOptions().getText());
        });
        return SubscriptionModel.builder()
                .id((Long) dbSubscription.getObjectId().getIdSnapshot().get("id"))
                .days(dbSubscription.getDays())
                .cover(dbSubscription.getCover())
                .list(list)
                .months(dbSubscription.getMonths())
                .next(dbSubscription.getNext())
                .pre(dbSubscription.getPre())
                .price(dbSubscription.getPrice())
                .type(dbSubscription.getType())
                .build();
    }

    public static CertificateModel buildCertificateModel(DbCertificate dbCertificate) {
        List<String> list = new ArrayList<>();
        List<DbOptionCertificate> certificateToOption = dbCertificate.getCertificateToOption();
        certificateToOption.forEach(dbOptionCertificate -> {
            list.add(dbOptionCertificate.getOpsubToOptions().getText());
        });
        return CertificateModel.builder()
                .id((Long) dbCertificate.getObjectId().getIdSnapshot().get("id"))
                .cover(dbCertificate.getCover())
                .length(dbCertificate.getLength())
                .list(list)
                .months(dbCertificate.getMonths())
                .name(dbCertificate.getName())
                .price(dbCertificate.getPrice())
                .priceStr(dbCertificate.getPriceStr())
                .priceStr2(dbCertificate.getPriceStr2())
                .description(dbCertificate.getDescription())
                .build();
    }
}
