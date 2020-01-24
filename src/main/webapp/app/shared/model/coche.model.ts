import { Moment } from 'moment';

export interface ICoche {
  id?: number;
  marca?: string;
  modelo?: string;
  matricula?: string;
  precio?: number;
  vendido?: boolean;
  fechaventa?: Moment;
}

export class Coche implements ICoche {
  constructor(
    public id?: number,
    public marca?: string,
    public modelo?: string,
    public matricula?: string,
    public precio?: number,
    public vendido?: boolean,
    public fechaventa?: Moment
  ) {
    this.vendido = this.vendido || false;
  }
}
