import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICoche } from 'app/shared/model/coche.model';
import { CocheService } from './coche.service';

@Component({
  templateUrl: './coche-purchase-dialog.component.html'
})
export class CochePurchaseDialogComponent {
  coche?: ICoche;

  constructor(protected cocheService: CocheService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear(): void {
    this.activeModal.dismiss();
  }

  confirmPurchase(vendido: boolean): void {
    this.cocheService.update(coche.vendido);
  }
}
